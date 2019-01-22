package xyz.vimtool.chapter13.section6;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * split
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class SplitDemo {

    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}
