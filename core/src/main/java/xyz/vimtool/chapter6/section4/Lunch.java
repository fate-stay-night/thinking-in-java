package xyz.vimtool.chapter6.section4;

/**
 * 类的构造器设为private权限
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/12
 */
public class Lunch {

    void testPrivate() {
//        Soup1 soup1 = new Soup1();
    }

    void testStatic() {
        Soup1 soup1 = Soup1.makeSoup1();
    }

    void testSingleton() {
        Soup2.access().f();
    }
}

class Soup1 {

    private Soup1() {}

    public static Soup1 makeSoup1() {
        return new Soup1();
    }
}

class Soup2 {

    private Soup2() {}

    // 用到单例模式
    private static Soup2 soup2 = new Soup2();

    public static Soup2 access() {
        return soup2;
    }

    public void f() {}
}