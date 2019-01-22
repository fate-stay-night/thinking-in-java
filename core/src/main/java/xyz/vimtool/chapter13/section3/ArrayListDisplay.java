package xyz.vimtool.chapter13.section3;

import xyz.vimtool.chapter19.section7.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器toString
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class ArrayListDisplay {

    public static void main(String[] args) {
        List<Food.Coffee> coffees = new ArrayList<>();
        for (Food.Coffee c : Food.Coffee.values()) {
            coffees.add(c);
        }
        System.out.println(coffees);
    }
}
