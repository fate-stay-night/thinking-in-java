package xyz.vimtool.chapter21.section2;

import java.util.concurrent.ThreadFactory;

/**
 * 守护进程工厂
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-4-3
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
