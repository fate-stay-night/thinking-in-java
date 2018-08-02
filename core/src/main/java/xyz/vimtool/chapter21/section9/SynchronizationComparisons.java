package xyz.vimtool.chapter21.section9;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步性能比较，涉及到模版方法设计模式
 *
 * 由于BaseLine和AtomicTest并没有对accumulate()方法同步，
 * 而作者写的代码没有考虑到多线程修改index的问题，可能导致index越界，程序崩溃！
 * 在这个示例代码中一次timedTest()测试会启动N个Modifier对象（在N个线程中）同时对同一个index进行修改，
 * 可能存在某个线程对index++完成后任务被中断（判断 index 是否越界和置0的代码还没有被执行），
 * 另外一个线程又调用了index++，这样index 就有可能超出SIZE的大小！
 *
 * 由于这是性能测试，所以不能加锁，但可以通过赋值到临时变量i，
 * 并提前进行越界判断调整i和index，使得程序能够避免崩溃，正常进行性能测试。
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/30
 */
public class SynchronizationComparisons {

    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static LockTest lockTest = new LockTest();
    static AtomicTest atomicTest = new AtomicTest();

    static void test() {
        System.out.println("=================================");
        System.out.printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        baseLine.timedTest();
        synchronizedTest.timedTest();
        lockTest.timedTest();
        atomicTest.timedTest();

        Accumulator.report(synchronizedTest, baseLine);
        Accumulator.report(lockTest, baseLine);
        Accumulator.report(atomicTest, baseLine);

        Accumulator.report(synchronizedTest, lockTest);
        Accumulator.report(synchronizedTest, atomicTest);
        Accumulator.report(lockTest, atomicTest);
    }

    public static void main(String[] args) {
        int iterations = 5;

        System.out.println("Warmup");
        baseLine.timedTest();

        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycles *= 2;
        }

        Accumulator.executor.shutdown();
    }
}

abstract class Accumulator {

    public static long cycles = 50000L;

    private static final int N = 4;

    public static ExecutorService executor = Executors.newFixedThreadPool(N * 2);

    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);

    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        Random random = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = random.nextInt();
        }
    }

    public abstract void accumulate();

    public abstract long read();

    private class Modifier implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable {

        private volatile long value;

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                value = read();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void timedTest() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            executor.execute(new Modifier());
            executor.execute(new Reader());
        }

        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        duration = System.currentTimeMillis() - start;
        System.out.printf("%-13s: %13d\n", id, duration);
    }

    public static void report(Accumulator accumulator1, Accumulator accumulator2) {
        System.out.printf("%-22s: %.2f\n", accumulator1.id + "/" + accumulator2.id,
                (double) accumulator1.duration / (double) accumulator2.duration);
    }
}

class BaseLine extends Accumulator {

    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
//        value += preLoaded[index++];
//        if (index >= SIZE) {
//            index = 0;
//        }
//
        int i = index++;
        if (i >= SIZE) {
            index = 0;
            i = 0;
        }
        value += preLoaded[i];
    }

    @Override
    public long read() {
        return value;
    }
}

class SynchronizedTest extends Accumulator {

    {
        id = "synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator {

    {
        id = "Lock";
    }

    private Lock lock = new ReentrantLock();

    @Override
    public  void accumulate() {
        lock.lock();

        try {
            value += preLoaded[index++];
            if (index >= SIZE) {
                index = 0;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized long read() {
        lock.lock();

        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator {

    {
        id = "Atomic";
    }

    private AtomicInteger index = new AtomicInteger(0);

    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
//        int i = index.getAndIncrement();
//
//        value.getAndAdd(preLoaded[i]);
//
//        if (++i >= SIZE) {
//            index.set(0);
//        }

        int i = index.getAndIncrement();

        if(i >= SIZE){
            i = 0;
            index.set(0);
        }

        value.getAndAdd(preLoaded[i]);
    }

    @Override
    public long read() {
        return value.get();
    }
}