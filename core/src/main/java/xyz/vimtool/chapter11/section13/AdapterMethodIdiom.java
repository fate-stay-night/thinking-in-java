package xyz.vimtool.chapter11.section13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 适配器模式，在Iterable类中再添加新的支持foreach的迭代器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReversibleArrayList<String> reversibleArrayList = new ReversibleArrayList<>(
                Arrays.asList("To be or not to be".split(" ")));

        for (String s : reversibleArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : reversibleArrayList.reversed()) {
            System.out.print(s + " ");
        }
    }
}

class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<T> collection) {
        super(collection);
    }

    /**
     * 创建逆向迭代
     */
    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }
        };
    }
}