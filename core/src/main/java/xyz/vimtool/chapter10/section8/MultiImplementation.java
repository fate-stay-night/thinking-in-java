package xyz.vimtool.chapter10.section8;

/**
 * 内部类实现多重继承
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/8
 */
public class MultiImplementation {

    static void takesD(D d) {}

    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

class D {}

abstract class E {}

class Z extends D {

    E makeE() {
        return new E() {};
    }
}