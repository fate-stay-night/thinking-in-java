package xyz.vimtool.chapter4.section5;

/**
 * return
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class IfElse2 {

    static int test(int testval, int target) {
        if (testval > target) {
            return 1;
        } else if (testval < target) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(test(10, 5));
        System.out.println(test(5, 10));
        System.out.println(test(5, 5));
    }
}
