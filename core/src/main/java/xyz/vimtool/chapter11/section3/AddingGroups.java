package xyz.vimtool.chapter11.section3;

import java.util.*;

/**
 * 添加一组元素
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/13
 */
public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);

        collection.forEach(System.out::println);
        System.out.println("%%%%%%%%%");
        list.forEach(System.out::println);
    }
}
