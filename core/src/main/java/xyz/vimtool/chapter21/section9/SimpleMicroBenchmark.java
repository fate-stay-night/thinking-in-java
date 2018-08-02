package xyz.vimtool.chapter21.section9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 维基准测试
 * 各类互斥技术比较
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/30
 */
public class SimpleMicroBenchmark {

    static long test(Incrementable incrementable) {
        long start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++) {
            incrementable.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SimpleSynchronizedTest());
        long lockTime = test(new SimpleLockingTest());

        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("lock:         %1$10d\n", lockTime);
        System.out.printf("lock/synchronized = %1$.3f", (double) lockTime / (double) synchTime);
    }
}

abstract class Incrementable {

    protected long counter = 0;

    public abstract void increment();
}

class SimpleSynchronizedTest extends Incrementable {

    @Override
    public synchronized void increment() {
        ++counter;
    }
}

class SimpleLockingTest extends Incrementable {

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();

        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}