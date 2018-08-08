package xyz.vimtool.chapter3.section9;

/**
 * 指数记数法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class Exponents {

    public static void main(String[] args) {
        float expFloat = 1.39e-43f;
        System.out.println(expFloat);

        expFloat = 1.39E-43f;
        System.out.println(expFloat);

        double expDouble = 47e47d;
        System.out.println(expDouble);

        double expDouble2 = 47e47;
        System.out.println(expDouble2);
    }
}
