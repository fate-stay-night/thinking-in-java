package xyz.vimtool.chapter21.section5;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 任务间使用管道进行输入/输出
 * 管道基本上是一个阻塞队列
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class PipedIO {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Sender implements Runnable {

    private Random random = new Random(47);

    private PipedWriter pipedWriter = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return pipedWriter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c < 'z'; c++) {
                    pipedWriter.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println(e + " Sender write exception");
        } catch (InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {

    private PipedReader pipedReader;

    public Receiver(Sender sender) throws IOException {
        pipedReader = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + (char) pipedReader.read());
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}
