package xyz.vimtool.chapter13.section7;

import java.util.Scanner;

/**
 * Scanner定界符
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class ScannerDelimiter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt());
        }
    }
}
