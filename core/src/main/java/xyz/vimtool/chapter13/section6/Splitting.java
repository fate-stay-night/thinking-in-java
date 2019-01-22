package xyz.vimtool.chapter13.section6;

import java.util.Arrays;

/**
 * 字符串在正则表达式匹配处切割
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class Splitting {

    public static String knights = "Then, when you have found the shrubbery, " +
            "you must cut down the mightiest tree in the forest... with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
