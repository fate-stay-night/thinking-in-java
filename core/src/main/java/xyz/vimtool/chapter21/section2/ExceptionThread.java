package xyz.vimtool.chapter21.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 捕获线程异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/15
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());

        // 此处异常无法捕获
        try {
            ExecutorService executorService1 = Executors.newCachedThreadPool();
            executorService1.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception has been handled");
            e.printStackTrace();
        }

        Thread thread = new Thread(new ExceptionThread());
        thread.start();

        // 此处异常无法捕获
        try {
            Thread thread1 = new Thread(new ExceptionThread());
            thread1.start();
        } catch (Exception e) {
            System.out.println("Exception has been handled");
            e.printStackTrace();
        }
    }
}
