package xyz.vimtool.chapter21.section6;

/**
 * 哲学家就餐问题，死锁问题
 * 筷子
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/18
 */
public class Chopstick {

    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = false;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
