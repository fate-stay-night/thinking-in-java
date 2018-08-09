package xyz.vimtool.chapter5.section4;

/**
 * this关键字
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class PassingThis {

    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}

class Person {

    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {

    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {

    Apple getPeeled() {
        return Peeler.peel(this);
    }
}