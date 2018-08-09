package xyz.vimtool.chapter5.section8;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class ArrayNew {

    public static void main(String[] args) {
        int[] a;
        Random random = new Random(47);
        a = new int[random.nextInt(20)];

        System.out.println("length of a = " + a.length);
        System.out.println(Arrays.toString(a));
    }
}
