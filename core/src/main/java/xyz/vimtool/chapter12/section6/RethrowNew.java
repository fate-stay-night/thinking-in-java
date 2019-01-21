package xyz.vimtool.chapter12.section6;

/**
 * 捕获异常，抛出新的异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class RethrowNew {

    public static void f() throws OneException {
        System.out.println("originating the exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

class OneException extends Exception {

    public OneException(String s) {
        super(s);
    }
}

class TwoException extends Exception {

    public TwoException(String s) {
        super(s);
    }
}