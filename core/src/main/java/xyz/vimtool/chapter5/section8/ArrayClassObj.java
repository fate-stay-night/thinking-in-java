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
public class ArrayClassObj {

    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] a = new Integer[random.nextInt(20)];

        System.out.println("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(500);
        }
        System.out.println(Arrays.toString(a));
    }
}
