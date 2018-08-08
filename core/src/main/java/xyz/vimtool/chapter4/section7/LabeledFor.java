package xyz.vimtool.chapter4.section7;

/**
 * goto
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i = 0;
        outer:
        for (; true;) {
            inner:

            for (; i < 10; i++) {
                System.out.println("i = " + i);

                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }

                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }

                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }

                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }

                for (int j = 0; j < 5; j++) {
                    if (j == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
