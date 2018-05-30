package xyz.vimtool.chapter21.section3;

/**
 * 多线程示例，测试多线程时，共享资源竞争
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
