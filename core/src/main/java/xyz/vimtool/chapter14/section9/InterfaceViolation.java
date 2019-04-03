package xyz.vimtool.chapter14.section9;

/**
 * 接口隔离
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-04-03
 */
public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();

        System.out.println(a.getClass().getName());

        if (a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}

class B implements A {

    @Override
    public void f() {}

    public void g() {}
}