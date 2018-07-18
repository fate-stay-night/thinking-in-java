package xyz.vimtool.chapter21.section6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家就餐问题，正确版
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/18
 */
public class FixedDiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int ponder = 1;

        int size = 5;

        ExecutorService executorService = Executors.newCachedThreadPool();

        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < size; i++) {
            if (i < size -1) {
                executorService.execute(new Philosopher(chopsticks[i], chopsticks[i + 1], i, ponder));
            } else {
                executorService.execute(new Philosopher(chopsticks[0], chopsticks[i], i, ponder));
            }
        }

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
