package xyz.vimtool.chapter5.section2;

/**
 * 方法重载
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class Overloading {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree tree = new Tree(i);
            tree.info();
            tree.info("overload method");
        }

        new Tree();
    }
}

class Tree {

    int height;

    Tree() {
        System.out.println("Planting a seeding");
        height = 0;
    }

    Tree(int height) {
        System.out.println("Creating new Tree that is " + height + " feet tall");
        this.height = height;
    }

    void info() {
        System.out.println("Tree is " + height + " feet tall");
    }

    void info(String s) {
        System.out.println(s + ": Tree is " + height + " feet tall");
    }
}
