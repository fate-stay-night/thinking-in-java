package xyz.vimtool.chapter12.section7;

/**
 * 标准异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class NeverCaught {

    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
