package xyz.vimtool.chapter21.section3;

/**
 * 序列数字产生器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/30
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumber() {
        return serialNumber++; // not thread safe
    }
}
