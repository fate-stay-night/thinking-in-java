package xyz.vimtool.chapter21.section6;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家就餐问题，死锁问题
 * 哲学家
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/18
 */
public class Philosopher implements Runnable {

    /**
     * 左边筷子
     */
    private Chopstick left;

    /**
     * 右边筷子
     */
    private Chopstick right;

    /**
     * 哲学家编号
     */
    private final int id;

    /**
     * 思考因子（用于随机产生思考时长）
     */
    private final int ponderFactor;

    private Random random = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }

        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();

                System.out.println(this + " grabbing right");
                right.take();

                System.out.println(this + " grabbing left");
                left.take();

                System.out.println(this + " eating");
                pause();

                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
