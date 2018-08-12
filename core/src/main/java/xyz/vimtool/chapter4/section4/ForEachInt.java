package xyz.vimtool.chapter4.section4;

import static xyz.vimtool.chapter6.section1.Range.range;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class ForEachInt {

    public static void main(String[] args) {
        for (int i : range(10)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(5, 9)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(5, 20, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
