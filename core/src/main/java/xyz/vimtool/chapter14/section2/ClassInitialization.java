package xyz.vimtool.chapter14.section2;

import java.util.Random;

/**
 * 类初始化
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-28
 */
public class ClassInitialization {

    public static Random random = new Random(47);

    public static void main(String[] args) throws Exception {
        // 不进行初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println();

        System.out.println(Initable2.staticNonFinal);
        System.out.println();

        // Class.forName()立即进行初始化
        Class initable3  = Class.forName(Initable3.class.getName());
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

class Initable {

    static final int staticFinal = 47;

    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {

    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}