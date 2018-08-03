package xyz.vimtool.chapter21.section10;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 活动对象
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/3
 */
public class ActiveObjectDemo {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private Random random = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return executor.submit(() -> {
            System.out.println("Starting " + x + " + " + y);
            pause(500);
            return x + y;
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return executor.submit(() -> {
            System.out.println("Starting " + x + " + " + y);
            pause(2000);
            return x + y;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo demo = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();

        for (float f = 0.0F; f < 1.0F; f += 0.2F) {
            results.add(demo.calculateFloat(f, f));
        }

        for (int i = 0; i < 5; i++) {
            results.add(demo.calculateInt(i, i));
        }

        System.out.println("All asynchronous calls made");

        while (results.size() > 0) {
            for (Future<?> future : results) {
                if (future.isDone()) {
                    try {
                        System.out.println(future.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    results.remove(future);
                }
            }
        }

        demo.shutdown();
    }
}
