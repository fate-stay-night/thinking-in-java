package xyz.vimtool.chapter8.section2;

/**
 * "覆盖"私有方法
 * 只有非private方法才可以被覆盖
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class PrivateOverride {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Derived();
        privateOverride.f();
        ((Derived) privateOverride).f();
    }
}

class Derived extends PrivateOverride {

    public void f() {
        System.out.println("public f()");
    }
}