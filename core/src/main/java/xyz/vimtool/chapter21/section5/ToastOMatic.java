package xyz.vimtool.chapter21.section5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者（吐司机器）
 * 制作吐司，吐司抹黄油，吐司上果酱
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class ToastOMatic {

    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue, butteredQueue));
        executorService.execute(new Jammer(butteredQueue, finishedQueue));
        executorService.execute(new Eater(finishedQueue));

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

/**
 * 吐司
 */
class Toast {
    public enum Status {
        /**
         * 烤好的吐司，抹了黄油的吐司，涂了果酱的吐司
         */
        DRY, BUTTERED, JAMMED
    }

    private Status status = Status.DRY;

    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}


class ToastQueue extends LinkedBlockingQueue<Toast> {}

/**
 * 吐司制造者
 */
class Toaster implements Runnable {

    private ToastQueue toastQueue;

    private int count = 0;

    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));

                // 创建吐司
                Toast toast = new Toast(count++);
                System.out.println(toast);

                // 放入队列
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }

        System.out.println("Toaster off");
    }
}

/**
 * 抹黄油者
 */
class Butterer implements Runnable {

    private ToastQueue dryQueue, butterQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butterQueue) {
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 取一个烤好的吐司，并抹上黄油
                Toast dry = dryQueue.take();
                dry.butter();

                // 抹好黄油，添加到队列
                System.out.println(dry);
                butterQueue.put(dry);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer Interrupted");
        }

        System.out.println("Butterer off");
    }
}

/**
 * 涂果酱者
 */
class Jammer implements Runnable {

    private ToastQueue butterQueue, finishedQueue;

    public Jammer(ToastQueue butterQueue, ToastQueue finishedQueue) {
        this.butterQueue = butterQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 取一个抹上黄油的吐司，并涂上果酱
                Toast butter = butterQueue.take();
                butter.jam();

                // 抹好果酱，添加到队列
                System.out.println(butter);
                finishedQueue.put(butter);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer Interrupted");
        }

        System.out.println("Jammer off");
    }
}

/**
 * 吃吐司者
 */
class Eater implements Runnable {

    private ToastQueue finishedQueue;

    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast finished = finishedQueue.take();

                if (finished.getId() != counter++
                        || !Toast.Status.JAMMED.equals(finished.getStatus())) {
                    System.out.println(">>>>> Error: " + finished);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + finished);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }

        System.out.println("Eater off");
    }
}
