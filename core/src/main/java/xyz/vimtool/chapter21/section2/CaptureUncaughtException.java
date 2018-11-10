package xyz.vimtool.chapter21.section2;

import java.util.concurrent.*;

/**
 * 捕获线程异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/15
 */
public class CaptureUncaughtException {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        ExecutorService executorService = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), new HandlerThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

/**
 * 线程异常处理器
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

/**
 * 线程生产工厂，添加线程异常处理器
 */
class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);

        // 设置异常处理器，捕获线程异常
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}