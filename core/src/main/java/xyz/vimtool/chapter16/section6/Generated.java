package xyz.vimtool.chapter16.section6;

import xyz.vimtool.chapter15.section3.Generator;
import xyz.vimtool.chapter17.section2.CollectionData;

import java.lang.reflect.Array;

/**
 * 数组生成器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/31
 */
public class Generated {

    public static <T> T[] array(T[] array, Generator<T> generator) {
        CollectionData<T> data = new CollectionData<>(generator, array.length);
        return data.toArray(array);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> generator, int size) {
        T[] array = (T[]) Array.newInstance(type, size);
        CollectionData<T> data = new CollectionData<>(generator, size);
        return data.toArray(array);
    }
}
