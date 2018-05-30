package xyz.vimtool.chapter21.section3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程示例，测试多线程时，共享资源竞争
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public synchronized int next() {
        // 互斥锁
        lock.lock();

        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
