package xyz.vimtool.chapter12.section4;

/**
 * 自定义异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class FullConstructors {

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

class MyException extends Exception {

    public MyException() {}

    public MyException(String msg) {
        super(msg);
    }
}