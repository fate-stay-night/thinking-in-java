package xyz.vimtool.chapter10.section8;

/**
 * 多接口实现
 * 内部类作用：每个内部类都能独立地继承自一个接口的实现，所有无论外围类是否已经继承类某个接口的实现，对于内部类都没有影响
 * 接口解决了部分的多重继承问题，内部类解决其他部分的多重继承问题(多重抽象类/具体类)
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/8
 */
public class MultiInterfaces {

    static void takesA(A a) {}

    static void takesB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}

interface A {}

interface B {}

class X implements A, B {}

class Y implements A {

    B makeB() {
        return new B() {};
    }
}