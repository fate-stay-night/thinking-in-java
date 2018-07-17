package xyz.vimtool.chapter21.section5;

import java.util.concurrent.*;

/**
 * notify和notifyAll比较
 * 当notifyAll()因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task());
        }
        executorService.execute(new Task2());

        // 定时任务
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod) {
                    System.out.println("notify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400L, 400, TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(5);
        scheduledExecutorService.shutdownNow();
        System.out.println("Timer canceled");

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shutting down");
        executorService.shutdownNow();
    }
}

class Blocker {

    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + "");
            }
        } catch (InterruptedException e) {
            // Ok to exit this way
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}