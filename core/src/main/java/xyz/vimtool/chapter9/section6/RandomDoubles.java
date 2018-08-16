package xyz.vimtool.chapter9.section6;

import java.util.Random;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class RandomDoubles {

    private static Random random = new Random(47);

    public double next() {
        return random.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
