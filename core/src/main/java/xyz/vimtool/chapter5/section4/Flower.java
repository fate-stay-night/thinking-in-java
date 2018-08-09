package xyz.vimtool.chapter5.section4;

/**
 * 构造器中调用构造器
 * 用this可以调用一个构造器，但是不能调用两个构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class Flower {

    int petalCount = 0;

    String s = "initial value";

    Flower(int petalCount) {
        this.petalCount = petalCount;
        System.out.println("Constructor w/ int arg only, petalCount = " + this.petalCount);
    }

    Flower(String s) {
        this.s = s;
        System.out.println("Constructor w/ String arg only, s = " + this.s);
    }

    Flower(String s, int petalCount) {
        this(petalCount);
        this.s = s;
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount() {
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCount();
    }
}
