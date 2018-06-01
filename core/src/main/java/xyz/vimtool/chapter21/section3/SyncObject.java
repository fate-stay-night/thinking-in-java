package xyz.vimtool.chapter21.section3;

/**
 * 同步对象
 * 两个任务同时进入同一个对象，只要这个对象上的方法是在不同的锁上同步即可
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/6/1
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSync ds = new DualSync();
        new Thread(() -> ds.f()).start();
        ds.g();
    }
}

// 两个方法用了两个相互独立的同步，所以相互不会被阻塞
class DualSync {
    private Object syncObject = new Object();

    // 这里实现同步是锁的this即DualSync对象
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    // 这里实现同步是锁的syncObject对象
    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
