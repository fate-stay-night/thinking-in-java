package xyz.vimtool.chapter21.section2;

/**
 * 定义任务
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-20
 */
public class LiftOff implements Runnable {

    protected int countDown = 10; //default

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            // 线程让步竞争
            Thread.yield();
        }
    }
}
