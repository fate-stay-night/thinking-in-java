package xyz.vimtool.chapter19.section6;

import java.util.Random;

/**
 * 随机选取枚举值
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */
public class Enums {

    private static Random rand = new Random(47);

    //通过反射Class.getEnumConstants()来随机选取
    public static <T extends Enum<T>> T random(Class<T> ec) {
        //通过Class.getEnumConstants()方法取得所有enum实例
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        //随机选取
        return values[rand.nextInt(values.length)];
    }
}
