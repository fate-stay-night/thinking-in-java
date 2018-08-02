package xyz.vimtool.chapter21.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/2
 */
public class ReaderWriterList<T> {

    private ArrayList<T> lockedList;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<>(Collections.nCopies(size, initialValue));
    }

    public T set(int index, T element) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            // 返回以前的元素
            return lockedList.set(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    public T get(int index) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            if (lock.getReadLockCount() > 1) {
                System.out.println(lock.getReadLockCount());
            }

            return lockedList.get(index);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        new ReaderWriterListTest(30, 1);
    }
}

class ReaderWriterListTest {

    private final static int SIZE = 100;

    private static Random random = new Random(47);

    private ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE, 0);

    ExecutorService executor = Executors.newCachedThreadPool();

    public ReaderWriterListTest(int readers, int writers) {
        for (int i = 0; i < readers; i++) {
            executor.execute(new Reader());
        }

        for (int i = 0; i < writers; i++) {
            executor.execute(new Writer());
        }
    }

    private class Writer implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i, random.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Writer finished, shutting down");
            executor.shutdownNow();
        }
    }

    private class Reader implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
