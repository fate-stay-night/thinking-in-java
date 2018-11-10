package xyz.vimtool.chapter10.section9;

/**
 * 内部类的继承
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class InheritInner extends WithInner.Inner {

    InheritInner(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
    }
}

class WithInner {

    class Inner {}
}