package xyz.vimtool.chapter13.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * toString打印出对象的内存地址
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        // 造成死循环
//        return " InfiniteRecursion address : " + this + "\n";

        return " InfiniteRecursion address : " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> infiniteRecursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            infiniteRecursions.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursions);
    }
}
