package xyz.vimtool.chapter13.section6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class TestRegularExpression {

    public static void main(String[] args) {
        String[] test = new String[]{"abcabcabcdefabc", "abc+", "abc+", "(abc){2,}"};

        System.out.println("Input: \"" + test[0] + "\"");
        for (String s : test) {
            System.out.println("Regular expression: \"" + s + "\"");
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(test[0]);
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at positions "
                        + matcher.start() + "-" + (matcher.end() - 1));
            }
        }
    }
}
