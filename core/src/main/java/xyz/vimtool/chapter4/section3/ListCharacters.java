package xyz.vimtool.chapter4.section3;

/**
 * for
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class ListCharacters {

    public static void main(String[] args) {
        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) {
                System.out.println("value: " + (int) c + " character: " + c);
            }
        }

        for (char c = 0; c < 128; c++) {
            if (Character.isUpperCase(c)) {
                System.out.println("value: " + (int) c + " character: " + c);
            }
        }
    }
}
