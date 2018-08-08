package xyz.vimtool.chapter4.section2;

/**
 * if-else
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class IfElse {

    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target) {
            result = +1;
        } else if (testval < target) {
            result = -1;
        } else {
            result = 0;
        }
    }

    public static void main(String[] args) {
        test(10, 5);
        System.out.println(result);

        test(5, 10);
        System.out.println(result);

        test(5, 5);
        System.out.println(result);
    }
}
