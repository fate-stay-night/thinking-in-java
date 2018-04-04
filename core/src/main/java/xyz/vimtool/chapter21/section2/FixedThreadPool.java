package xyz.vimtool.chapter21.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有限的线程集
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-20
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        //Constructor argument is number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
