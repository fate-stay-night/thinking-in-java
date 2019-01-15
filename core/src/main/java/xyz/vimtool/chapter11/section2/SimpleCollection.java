package xyz.vimtool.chapter11.section2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 简单的容器示例
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/13
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }

        for (Integer i : collection) {
            System.out.print(i + " ");
        }
    }
}
