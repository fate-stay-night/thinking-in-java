package xyz.vimtool.chapter11.section13;

import java.util.Arrays;

/**
 * 数组未实现iterable，不支持foreach格式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class ArrayIsNotIterable {

    static <T> void test(Iterable<T> iterable) {
        for (T t : iterable) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
