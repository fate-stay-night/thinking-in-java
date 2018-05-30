package xyz.vimtool.chapter21.section3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 互斥锁测试
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();

        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available

        // Now create a separate task to grab the lock:
        new Thread() {
            {setDaemon(true);}

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        Thread.yield();
        al.untimed(); // False -- lock grabbed by task
        al.timed(); // False -- lock grabbed by task
    }
}
