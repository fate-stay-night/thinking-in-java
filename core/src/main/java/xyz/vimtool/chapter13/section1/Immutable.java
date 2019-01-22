package xyz.vimtool.chapter13.section1;

/**
 * 不可变String
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);

        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
