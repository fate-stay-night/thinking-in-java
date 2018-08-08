package xyz.vimtool.chapter3.section17;

/**
 * 值溢出
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class Overflow {

    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);

        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
}
