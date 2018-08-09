package xyz.vimtool.chapter5.section1;

/**
 * 简单构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }

        System.out.println();

        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}

class Rock {

    Rock() {
        System.out.print("Rock ");
    }
}

class Rock2 {

    Rock2(int i) {
        System.out.print("Rock " + i + " ");
    }
}