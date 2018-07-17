package xyz.vimtool.chapter21.section4;

/**
 * 同一互斥可以被同一任务多次获得
 * 一个任务能够调用在同一个对象中的其他的synchronized方法，因为这个任务已经持有该对象锁了
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/16
 */
public class MultiLock {

    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();

        new Thread(() -> multiLock.f1(10)).start();
    }
}
