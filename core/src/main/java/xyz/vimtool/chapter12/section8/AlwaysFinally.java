package xyz.vimtool.chapter12.section8;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class AlwaysFinally {

    public static void main(String[] args) {
        System.out.println("Entering first try block");

        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}

class FourException extends Exception {}