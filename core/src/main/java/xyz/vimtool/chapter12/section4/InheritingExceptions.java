package xyz.vimtool.chapter12.section4;

/**
 * 自定义异常
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Throw simpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();

        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

class  SimpleException extends Exception {}