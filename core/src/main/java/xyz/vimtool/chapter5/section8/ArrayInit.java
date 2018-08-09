package xyz.vimtool.chapter5.section8;

import java.util.Arrays;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class ArrayInit {

    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3,
        };

        Integer[] b = new Integer[] {
                new Integer(1),
                new Integer(2),
                3,
        };

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
