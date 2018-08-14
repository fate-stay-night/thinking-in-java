package xyz.vimtool.chapter8.section3;

/**
 * 组合、继承、多态在构建顺序上的作用
 * 构造器调用顺序：
 * 1 调用基类构造器
 * 2 按照声明顺序调用成员的初始化方法
 * 3 调用导出类构造器的主体
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Sandwich extends PortableLunch {

    private Bread b = new Bread();

    private Cheese c = new Cheese();

    private Lettuce l = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal {

    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {

    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {

    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {

    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {

    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {

    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}