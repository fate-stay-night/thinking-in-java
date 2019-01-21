package xyz.vimtool.chapter12.section8;

/**
 * 在return中使用finally
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if (i == 1) {
                return;
            }

            System.out.println("Point 2");
            if (i == 2) {
                return;
            }

            System.out.println("Point 3");
            if (i == 3) {
                return;
            }

            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            f(i);
        }
    }
}
