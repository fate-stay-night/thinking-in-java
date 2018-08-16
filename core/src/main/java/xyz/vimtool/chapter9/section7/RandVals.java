package xyz.vimtool.chapter9.section7;

import java.util.Random;

/**
 * 接口中的域默认是static&final
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public interface RandVals {

    Random RAND = new Random(47);

    int RANDOM_INT = RAND.nextInt(10);

    long RANDOM_LONG = RAND.nextLong() * 10;

    float RANDOM_FLOAT = RAND.nextLong() * 10;

    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
