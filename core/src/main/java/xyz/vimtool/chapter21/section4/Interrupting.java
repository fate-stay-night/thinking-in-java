package xyz.vimtool.chapter21.section4;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * I/O和在Synchronized块上的等待是不可中断的
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/16
 */
public class Interrupting {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = executorService.submit(r);

        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("Interrupting " + r.getClass().getName());
        // 中断
        f.cancel(true);

        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBLocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");

        System.exit(0);
    }
}

/**
 * 可中断的阻塞示例
 */
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        System.out.println("Exiting SleepBlocked.run()");
    }
}

/**
 * 不可中断的阻塞示例
 */
class IOBLocked implements Runnable {

    private InputStream in;

    public IOBLocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Exiting IOBlocked.run()");
    }
}

/**
 * 不可中断的阻塞示例
 */
class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        // never releases lock
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(() -> {
            // lock acquired by this thread
            f();
        }).start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}


