package xyz.vimtool.chapter21.section4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * nio类自动响应中断
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/16
 */
public class NIOInterruption {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);

        SocketChannel sc1 = SocketChannel.open(inetSocketAddress);
        SocketChannel sc2 = SocketChannel.open(inetSocketAddress);

        Future<?> f = executorService.submit(new NIOBlocked(sc1));
        executorService.execute(new NIOBlocked(sc2));
        executorService.shutdown();

        TimeUnit.SECONDS.sleep(1);
        // Produce an interrupt via cancel
        f.cancel(true);

        TimeUnit.SECONDS.sleep(1);
        // Release the block by closing the channel
        sc2.close();
    }
}

class NIOBlocked implements Runnable {

    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Exiting NIOBlocked.run() " + this);
    }
}
