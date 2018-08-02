package xyz.vimtool.chapter17.section2;

import xyz.vimtool.chapter15.section3.Generator;

import java.util.ArrayList;

/**
 * 集合数据构造
 * 适配器设计模式：CollectionData将Generator适配到Collection的构造器上
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/31
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int quantity) {
        return new CollectionData<>(generator, quantity);
    }
}
