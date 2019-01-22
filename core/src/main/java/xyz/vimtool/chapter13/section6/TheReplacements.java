package xyz.vimtool.chapter13.section6;

import xyz.vimtool.chapter18.section7.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换操作
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class TheReplacements {

    public static void main(String[] args) {
        String s = TextFile.read("core/src/main/java/xyz/vimtool/chapter13/section6/TheReplacements.java");
        Matcher matcher = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);

        if (matcher.find()) {
            s = matcher.group(1);
        }
        System.out.println(s);
        s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");

        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            m.appendReplacement(stringBuffer, m.group().toUpperCase());
        }
        m.appendTail(stringBuffer);
        System.out.println(stringBuffer);
    }
}
