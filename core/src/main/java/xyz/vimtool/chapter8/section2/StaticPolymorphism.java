package xyz.vimtool.chapter8.section2;

/**
 * 类的属性及静态方法不可多态
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        // 这里为了测试静态方法不可多态，所以使用类对象调用静态方法
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}

class StaticSuper {

    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {

    public static String staticGet() {
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}