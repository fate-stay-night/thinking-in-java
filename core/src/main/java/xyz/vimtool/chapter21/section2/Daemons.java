package xyz.vimtool.chapter21.section2;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程实例
 * 后台线程派生的子线程也是后台线程
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/15
 */
public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread.isDaemon() = " + thread.isDaemon() + ", ");

        TimeUnit.SECONDS.sleep(1);
    }

}

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.print("DaemonSpawn " + i + " started, ");
        }

        for (int i = 0; i < t.length; i++) {
            System.out.print("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }

        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}


