package xyz.vimtool.chapter21.section3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 序列数字产生器检测
 * 此列检测序列数字产生器非线程安全
 * 如需线程安全，在函数nextSerialNumber()前添加synchronized
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class SerialNumberChecker {

    private static final int SIZE = 10;

    private static CircularSet serials = new CircularSet(1000);

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();

                if (serials.contains(serial)) {
                    System.out.println("Duplcate: " + serial);
                    System.exit(0);
                }

                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new SerialChecker());
        }

        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}

class CircularSet {
    private int[] array;

    private int len;

    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;

        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;

        // Wrap index and write over old elements
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }

        return false;
    }
}
