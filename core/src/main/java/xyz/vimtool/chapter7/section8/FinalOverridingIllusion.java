package xyz.vimtool.chapter7.section8;

/**
 * final方法
 * 使用final方法的原因：1 把方法锁定，防止任何继承类修改它的含义 2 效率（类似内联函数）
 * 类中所有的private方法都隐式地指定为final
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        OverridingPrivate op = op2;
        // 不能调用f(),g()
//        op.f();
//        op.g();

        WithFinals wf = op2;
        // 不能调用f(),g()
//        wf.f();
//        wf.g();
    }
}

class WithFinals {

    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {

    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {

    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}