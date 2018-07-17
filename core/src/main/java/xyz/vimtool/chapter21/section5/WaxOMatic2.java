package xyz.vimtool.chapter21.section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock and Condition
 * 结合汽车涂蜡、抛光这一示例
 * Lock和Condition只有在更加困难的多线程问题中才是必需的
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class WaxOMatic2 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Car2 car = new Car2();
        executorService.execute(new WaxOn2(car));
        executorService.execute(new WaxOff2(car));

        TimeUnit.SECONDS.sleep(5);

        // 中断关闭任务
        executorService.shutdownNow();
    }
}

class Car2 {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    /**
     * 涂蜡状态
     */
    private boolean waxOn = false;

    /**
     * 涂蜡完成
     */
    public void waxed() {
        lock.lock();

        try {
            waxOn = true;
            // 唤醒任务
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 抛光完成
     */
    public void buffed() {
        lock.lock();

        try {
            waxOn = false;
            // 唤醒任务
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 等待涂蜡
     */
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            // 抛光完成就进行涂蜡
            while (!waxOn) {
                // 调用wait之后，锁被释放
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 等待抛光
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            // 涂蜡完成就进行抛光
            while (waxOn) {
                // 调用wait之后，锁被释放
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 涂蜡处理
 */
class WaxOn2 implements Runnable {

    private Car2 car2;

    public WaxOn2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                // 涂蜡完成，等待抛光
                car2.waxed();
                car2.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax on task");
    }
}

/**
 * 涂蜡完成后，进行抛光处理，即涂蜡之后的处理
 */
class WaxOff2 implements Runnable {

    private Car2 car2;

    public WaxOff2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 等待涂蜡完成
                car2.waitForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax off task");
    }
}
