package xyz.vimtool.chapter11.section9;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 有序Set
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class SortedSetOfInteger {

    public static void main(String[] args) {
        Random random = new Random(47);
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(random.nextInt(30));
        }
        System.out.println(set);
    }
}
