package xyz.vimtool.chapter3.section4;

/**
 * 方法调用中的别名问题
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class PassObject {

    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.c = 'a';
        System.out.println("1: letter.c " + letter.c);

        f(letter);
        System.out.println("2: letter.c " + letter.c);
    }
}

class Letter {
    char c;
}
