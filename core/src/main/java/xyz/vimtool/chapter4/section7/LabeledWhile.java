package xyz.vimtool.chapter4.section7;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class LabeledWhile {

    public static void main(String[] args) {
        int i = 0;

        outer:
        while (true) {
            System.out.println("Outer while loop");
            while (true) {
                i++;
                System.out.println("i = " + i);

                if (i == 1) {
                    System.out.println("continue");
                    continue;
                }

                if (i == 3) {
                    System.out.println("continue outer");
                    continue outer;
                }

                if (i == 5) {
                    System.out.println("break");
                    break;
                }

                if (i == 7) {
                    System.out.println("break outer");
                    break outer;
                }
            }
        }
    }
}
