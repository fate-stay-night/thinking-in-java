package xyz.vimtool.chapter21.section2;

import java.util.concurrent.TimeUnit;

/**
 * 守护进程
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-4-3
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());

            // 设置为守护进程，必须在start()之前
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
