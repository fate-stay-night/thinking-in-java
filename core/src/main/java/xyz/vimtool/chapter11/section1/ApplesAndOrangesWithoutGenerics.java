package xyz.vimtool.chapter11.section1;

import java.util.ArrayList;

/**
 * 泛型与类型安全的容器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/12
 */
public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());

        for (int i = 0; i < apples.size(); i++) {
            ((Apple) apples.get(i)).id();
            // Orange is detected only at run time
        }
    }
}

class Apple {

    private static long counter;

    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {}