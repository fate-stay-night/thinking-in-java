package xyz.vimtool.chapter4.section6;

import xyz.vimtool.chapter4.section4.ForEachInt;

/**
 * break and continue
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class BreakAndContinue {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 74) {
                break;
            }

            if ((i % 9) != 0) {
                continue;
            }

            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : ForEachInt.range(100)) {
            if (i == 74) {
                break;
            }

            if ((i % 9) != 0) {
                continue;
            }

            System.out.print(i + " ");
        }
        System.out.println();

        int i = 0;
        while (true) {
            i++;
            int j = i * 27;
            if (j == 1269) {
                break;
            }

            if (i % 10 != 0) {
                continue;
            }

            System.out.print(i + " ");
        }
    }
}
