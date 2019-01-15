package xyz.vimtool.chapter11.section13;

import java.util.*;

/**
 * 多迭代器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class MultiIterableClass extends IterableClass {

    /**
     * 逆向迭代器
     */
    public Iterable<String> reversed() {
        return () -> new Iterator<String>() {
            int current = words.length - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public String next() {
                return words[current--];
            }
        };
    }

    /**
     * 随机迭代器
     */
    public Iterable<String> randomized() {
        return () -> {
            List<String> shuffled = new ArrayList<>(Arrays.asList(words));
            Collections.shuffle(shuffled, new Random(47));
            return shuffled.iterator();
        };
    }

    public static void main(String[] args) {
        MultiIterableClass multi = new MultiIterableClass();

        for (String s : multi.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : multi.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : multi) {
            System.out.print(s + " ");
        }
    }
}
