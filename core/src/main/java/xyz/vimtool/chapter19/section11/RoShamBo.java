package xyz.vimtool.chapter19.section11;

import xyz.vimtool.chapter19.section6.Enums;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-28
 */
public class RoShamBo {

    //注意方法的基于泛型的返回值类型并比较
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b +": " + a.compete(b));
    }

    //注意方法的基于泛型的返回值类型并比较
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}
