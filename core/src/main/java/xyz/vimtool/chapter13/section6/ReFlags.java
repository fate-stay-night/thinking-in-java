package xyz.vimtool.chapter13.section6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则标记
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class ReFlags {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher("java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expression\n" +
                "Regular expressions are in Java");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
