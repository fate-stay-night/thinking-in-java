package xyz.vimtool.chapter8.section2;

import java.util.Random;

/**
 * 图形生成器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class RandomShapeGenerator {

    private Random random = new Random(47);

    public Shape next() {
        switch (random.nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Square();
            default:
                return new Triangle();
        }
    }
}
