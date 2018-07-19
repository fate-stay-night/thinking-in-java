package xyz.vimtool.chapter21.section7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 赛马游戏仿真
 * CyclicBarrier适用情况：你希望创建一组任务，它们并行执行工作，然后在进行下一步骤之前等待，直到所有任务都完成
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/18
 */
public class HorseRace {

    static final int FINISH_LINE = 75;

    private List<Horse> horses = new ArrayList<>();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++) {
                builder.append("=");
            }
            System.out.println(builder);

            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }

            for (Horse horse : horses) {
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + " won!");
                    executorService.shutdown();
                    return;
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("barrier-action sleep interrupted");
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;

        int pause = 200;

        new HorseRace(nHorses, pause);
    }
}

class Horse implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private int strides = 0;

    private static Random random = new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized int getStrides() {
        return strides;
    }

    public String tracks() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            builder.append("*");
        }
        builder.append(id);
        return builder.toString();
    }
}
