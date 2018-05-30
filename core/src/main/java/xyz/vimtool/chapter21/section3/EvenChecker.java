package xyz.vimtool.chapter21.section3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 偶数检查器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/15
 */
public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;

    private final int id;

    public EvenChecker(IntGenerator intGenerator, int ident) {
        this.intGenerator = intGenerator;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();

            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                intGenerator.cancel();
            }
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(gp, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
