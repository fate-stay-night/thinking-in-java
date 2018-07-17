package xyz.vimtool.chapter21.section4;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 通过关闭任务在其上发生阻塞的底层资源，
 * 来实现中断正在是他获取synchronized锁或试图执行I/O操作的线程
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/16
 */
public class CloseResource {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();

        executorService.execute(new IOBLocked(socketInput));
        executorService.execute(new IOBLocked(System.in));

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shutting down all threads");
        executorService.shutdownNow();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + socketInput.getClass().getName());
        // releases blocked thread
        socketInput.close();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getName());
        // releases blocked thread
        System.in.close();
    }
}
