package xyz.vimtool.chapter3.section5;

import java.util.Random;

/**
 * 算术操作符
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class MathOps {

    public static void main(String[] args) {
        Random random = new Random(47);
        int i, j, k;

        j = random.nextInt(100) + 1;
        System.out.println("j: " + j);

        k = random.nextInt(100) + 1;
        System.out.println("k: " + k);

        i = j + k;
        System.out.println("j + k : " + i);

        i = j - k;
        System.out.println("j - k : " + i);

        i = k / j;
        System.out.println("k / j : " + i);

        i = k * j;
        System.out.println("k * j : " + i);

        i = k % j;
        System.out.println("k % j : " + i);

        j %= k;
        System.out.println("j %= k : " + j);


        float u, v, w;
        v = random.nextFloat();
        System.out.println("v : " + v);

        w = random.nextFloat();
        System.out.println("w : " + w);

        u = v + w;
        System.out.println("v + w :" + u);

        u = v - w;
        System.out.println("v - w :" + u);

        u = v * w;
        System.out.println("v * w :" + u);

        u = v / w;
        System.out.println("v / w :" + u);

        u += v;
        System.out.println("u += v : " + u);

        u -= v;
        System.out.println("u -= v : " + u);

        u *= v;
        System.out.println("u *= v : " + u);

        u /= v;
        System.out.println("u /= v : " + u);
    }
}
