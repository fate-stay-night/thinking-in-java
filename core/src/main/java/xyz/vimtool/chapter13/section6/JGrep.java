package xyz.vimtool.chapter13.section6;

import xyz.vimtool.chapter18.section7.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式与Java I/O
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class JGrep {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\b[Ssct]\\w+");
        int index = 0;
        Matcher matcher = pattern.matcher("");
        for (String line : new TextFile("core/src/main/java/xyz/vimtool/chapter13/section6/JGrep.java")) {
            matcher.reset(line);
            while (matcher.find()) {
                System.out.println(index++ + ": " + matcher.group() + ": " + matcher.start());
            }
        }
    }
}
