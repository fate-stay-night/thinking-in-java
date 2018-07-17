package xyz.vimtool.chapter21.section5;

import xyz.vimtool.chapter21.section2.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 生产者消费者与队列
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class TestBlockingQueues {

    /**
     * 终端输入
     */
    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String message, BlockingQueue<LiftOff> queue) {
        System.out.println(message);

        LiftOffRunner liftOffRunner = new LiftOffRunner(queue);
        Thread thread = new Thread(liftOffRunner);
        thread.start();

        for (int i = 0; i < 5; i++) {
            liftOffRunner.add(new LiftOff(5));
        }

        // 终端输入停止程序
        getKey("Press Enter (" + message + ")");

        thread.interrupt();
        System.out.println("Finished " + message + "test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
        test("SynchronousQueue", new SynchronousQueue<>());
    }
}

/**
 * 生产者
 */
class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff liftOff) {
        try {
            // 添加到队列
            rockets.put(liftOff);
        } catch (Exception e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 队列中取值
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
