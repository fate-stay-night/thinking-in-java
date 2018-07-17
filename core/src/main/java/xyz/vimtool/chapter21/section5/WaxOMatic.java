package xyz.vimtool.chapter21.section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * wait and notify
 * 结合汽车涂蜡、抛光这一示例，说明wait和notify的用法
 * 调用wait等待时，锁会释放
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class WaxOMatic {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Car car = new Car();
        executorService.execute(new WaxOn(car));
        executorService.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(5);

        // 中断关闭任务
        executorService.shutdownNow();
    }
}

class Car {

    /**
     * 涂蜡状态
     */
    private boolean waxOn = false;

    /**
     * 涂蜡完成
     */
    public synchronized void waxed() {
        waxOn = true;
        // 唤醒任务
        notifyAll();
    }

    /**
     * 抛光完成
     */
    public synchronized void buffed() {
        waxOn = false;
        // 唤醒任务
        notifyAll();
    }

    /**
     * 等待涂蜡
     */
    public synchronized void waitForWaxing() throws InterruptedException {
        // 抛光完成就进行涂蜡
        while (!waxOn) {
            // 调用wait之后，锁被释放
            wait();
        }
    }

    /**
     * 等待抛光
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        // 涂蜡完成就进行抛光
        while (waxOn) {
            // 调用wait之后，锁被释放
            wait();
        }
    }
}

/**
 * 涂蜡处理
 */
class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                // 涂蜡完成，等待抛光
                car.waxed();
                car.waitForBuffing();
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
class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 等待涂蜡完成
                car.waitForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax off task");
    }
}
