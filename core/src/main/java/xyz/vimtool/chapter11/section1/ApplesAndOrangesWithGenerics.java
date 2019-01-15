package xyz.vimtool.chapter11.section1;

import java.util.ArrayList;

/**
 * 容器中使用泛型
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/12
 */
public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        // 编译错误
//        apples.add(new Orange());

        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }

        for (Apple apple : apples) {
            System.out.println(apple.id());
        }
    }
}