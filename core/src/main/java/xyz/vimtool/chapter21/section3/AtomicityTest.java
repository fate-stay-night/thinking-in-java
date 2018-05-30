package xyz.vimtool.chapter21.section3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 原子性操作测试, return i是原子操作，但是在i加的中间状态可以取值
 *
 * java递增操作不是原子操作
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        AtomicityTest atomicityTest = new AtomicityTest();
        executor.execute(atomicityTest);

        while (true) {
            int val = atomicityTest.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
