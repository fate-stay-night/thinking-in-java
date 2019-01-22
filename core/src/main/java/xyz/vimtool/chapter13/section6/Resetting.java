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
public class Resetting {

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();

        matcher.reset("fix the rig with rags");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
