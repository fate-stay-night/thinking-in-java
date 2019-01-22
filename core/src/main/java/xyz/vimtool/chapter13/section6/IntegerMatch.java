package xyz.vimtool.chapter13.section6;

/**
 * 正则表达式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class IntegerMatch {

    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
