package xyz.vimtool.chapter9.section5;

/**
 * 组合接口时的名字冲突
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class InterfaceCollision {
}

interface I1 {

    void f();
}

interface I2 {

    int f(int i);
}

interface I3 {

    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    @Override
    public void f() {}

    @Override
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {

    @Override
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {

    @Override
    public int f() {
        return 1;
    }
}

// 方法冲突
//class C5 extends C implements I1 {
//
//    @Override
//    public int f() {
//        return 1;
//    }
//}

// 方法冲突
//interface I4 extends I1, I3 {}