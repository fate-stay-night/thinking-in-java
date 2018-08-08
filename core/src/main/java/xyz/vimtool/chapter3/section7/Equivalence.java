package xyz.vimtool.chapter3.section7;

/**
 * 关系操作符
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class Equivalence {

    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);

        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println(n1.equals(n2));

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        // equals()默认比较引用
        System.out.println(v1.equals(v2));
    }
}

class Value {
    int i;
}
