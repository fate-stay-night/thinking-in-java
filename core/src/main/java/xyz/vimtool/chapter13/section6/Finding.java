package xyz.vimtool.chapter13.section6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class Finding {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("Evening is full of the linnet's wings");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        int i = 0;
        while (matcher.find(i)) {
            System.out.print(matcher.group() + " ");
            i++;
        }
    }
}
