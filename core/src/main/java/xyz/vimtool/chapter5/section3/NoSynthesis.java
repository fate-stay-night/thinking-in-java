package xyz.vimtool.chapter5.section3;

/**
 * 定义了构造器之后，就不会自动创建默认构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class NoSynthesis {

    public static void main(String[] args) {
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}

class Bird2 {
    Bird2(int i) {}

    Bird2(double d) {}
}
