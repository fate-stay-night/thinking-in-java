package xyz.vimtool.chapter11.section9;

import xyz.vimtool.chapter18.section7.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * 字典排序
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class UniqueWordsAlphabetic {

    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile("core/src/main/java/xyz/vimtool/chapter11/section9/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
