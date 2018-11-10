package xyz.vimtool.chapter10.section7;

/**
 * 从多层嵌套类中访问外部类的成员
 * 一个内部类被嵌套多少层并不重要，它能透明的访问所有它嵌入的外围类的所有成员
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}

class MNA {

    private void f() {}

    class A {

        private void g() {}

        public class B {

            void h() {
                g();
                f();
            }
        }
    }
}
