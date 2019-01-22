package xyz.vimtool.chapter13.section2;

import java.util.Random;

/**
 * 自己实现toString
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class UsingStringBuilder {

    public static Random rand = new Random(47);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder builder = new UsingStringBuilder();
        System.out.println(builder);
    }
}
