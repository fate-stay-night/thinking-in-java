package xyz.vimtool.chapter21.section7;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 任务间交换对象
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/26
 */
public class ExchangerDemo {

    static int size = 10;

    static int delay = 5;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>();
        List<Fat> consumerList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < ExchangerDemo.size; i++) {
            producerList.add(new Fat());
        }

        executor.execute(new ExchangerProducer<>(xc, Fat.class, producerList));
        executor.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        executor.shutdownNow();
    }
}

class ExchangerProducer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;

    private Class<T> classObject;

    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchanger, Class<T> classObject, List<T> holder) {
        this.exchanger = exchanger;
        this.classObject = classObject;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(classObject.newInstance());
                }
                holder = exchanger.exchange(holder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;

    private List<T> holder;

    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Iterator<T> iterator = holder.iterator();
                while (iterator.hasNext()) {
                    value = iterator.next();
                    iterator.remove();
                }
//                for (T x : holder) {
//                    value = x;
//                    holder.remove(x);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}
