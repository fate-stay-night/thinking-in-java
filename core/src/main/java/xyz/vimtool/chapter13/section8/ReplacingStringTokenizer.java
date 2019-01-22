package xyz.vimtool.chapter13.section8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class ReplacingStringTokenizer {

    public static void main(String[] args) {
        String input = "But I'm not dead yet! I feel happy!";
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        while (stringTokenizer.hasMoreElements()) {
            System.out.print(stringTokenizer.nextToken() + " ");
        }
        System.out.println();

        System.out.println(Arrays.toString(input.split(" ")));

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
