package xyz.vimtool.chapter4.section4;

import java.util.Random;

/**
 * foreach语法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class ForEachFloat {

    public static void main(String[] args) {
        Random random = new Random(47);
        float[] f = new float[10];

        for (int i = 0; i < 10; i++) {
            f[i] = random.nextFloat();
        }

        for (float x : f) {
            System.out.println(x);
        }
    }
}
