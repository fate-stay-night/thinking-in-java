package xyz.vimtool.chapter14.section9;

/**
 * 使用包权限控制来解耦
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-04-03
 */
public class HiddenC {

    public static A makeA() {
        return new C();
    }
}

class C implements A {

    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}