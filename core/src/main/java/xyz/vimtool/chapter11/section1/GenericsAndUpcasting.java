package xyz.vimtool.chapter11.section1;

import java.util.ArrayList;

/**
 * 容器中使用向上转型
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/13
 */
public class GenericsAndUpcasting {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for (Apple apple : apples) {
            System.out.println(apple);
        }
    }
}

class GrannySmith extends Apple {}

class Gala extends Apple {}

class Fuji extends Apple {}

class Braeburn extends Apple {}