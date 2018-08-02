package xyz.vimtool.chapter21.section9;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 快速仿真
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/1
 */
public class FastSimulation {

    static final int N_ELEMENTS = 100000;

    static final int N_GENES = 30;

    static final int N_EVOLVERS = 50;

    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENES];

    static Random random = new Random(47);

    static class Evoler implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                int element = random.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element - 1;

                    if (previous < 0) {
                        previous = N_ELEMENTS - 1;
                    }

                    int next = element + 1;
                    if (next >= N_ELEMENTS) {
                        next = 0;
                    }

                    int oldValue = GRID[element][i].get();

                    int newValue = oldValue + GRID[previous][i].get() + GRID[next][i].get();
                    newValue /= 3;

                    if (!GRID[element][i].compareAndSet(oldValue, newValue)) {
                        System.out.println("Old value changed from " + oldValue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < N_ELEMENTS; i++) {
            for (int j = 0; j < N_GENES; j++) {
                GRID[i][j] = new AtomicInteger(random.nextInt(1000));
            }
        }

        for (int i = 0; i < N_EVOLVERS; i++) {
            executor.execute(new Evoler());
        }

        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }
}
