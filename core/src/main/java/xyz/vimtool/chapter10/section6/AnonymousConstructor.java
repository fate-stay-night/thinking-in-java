package xyz.vimtool.chapter10.section6;

/**
 * 匿名类，通过实例初始化达到为匿名内部类创建一个构造器的效果
 * 一个匿名类，它通过实例初始化实现构造（匿名类不可能有构造器）
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class AnonymousConstructor {

    public static Base getBase(int i) {

        return new Base(i) {

            // 相当构造器的效果
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}

abstract class Base {

    public Base(int i) {
        System.out.println("Base constructor. i = " + i);
    }

    public abstract void f();
}
