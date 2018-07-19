package xyz.vimtool.chapter21.section7;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 锁存器
 * CountDownLatch被用来同步一个或多个任务，强制它们等待由其他任务执行的一组操作完成
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/18
 */
public class CountDownLatchDemo {

    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 同一个锁存器控制任务执行顺序
        CountDownLatch latch = new CountDownLatch(SIZE);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new TaskPortion(latch));
        }

        System.out.println("Launched all tasks");
        // quit when all tasks complete
        executorService.shutdown();
    }
}

/**
 * 任务节点
 */
class TaskPortion implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private static Random random = new Random(47);

    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}

/**
 * 等待任务
 */
class WaitingTask implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private final CountDownLatch latch;

    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}
