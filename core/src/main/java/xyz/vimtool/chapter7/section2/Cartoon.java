package xyz.vimtool.chapter7.section2;

/**
 * 初始化基类
 * Java会自动在导出类的构造器中插入对基类构造器的调用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class Cartoon extends Drawing {

    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}

class Art {

    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {

    Drawing() {
        System.out.println("Drawing constructor");
    }
}