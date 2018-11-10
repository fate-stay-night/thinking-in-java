package xyz.vimtool.chapter10.section8;

/**
 * 内部类与控制框架，事件驱动系统
 * 模版方法设计模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public abstract class Event {

    private long eventTime;

    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
