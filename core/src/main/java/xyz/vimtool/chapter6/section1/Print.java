package xyz.vimtool.chapter6.section1;

import java.io.PrintStream;

/**
 * 定制工具库
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class Print {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void print() {
        System.out.println();
    }

    public static void printnb(Object object) {
        System.out.print(object);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
