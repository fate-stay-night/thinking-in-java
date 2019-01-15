package xyz.vimtool.chapter11.section9;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Set
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class SetOfInteger {

    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(random.nextInt(30));
        }
        System.out.println(set);
    }
}
