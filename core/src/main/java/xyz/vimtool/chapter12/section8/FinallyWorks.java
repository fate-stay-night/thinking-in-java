package xyz.vimtool.chapter12.section8;

/**
 * finally字句
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class FinallyWorks {

    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

class ThreeException extends Exception {}