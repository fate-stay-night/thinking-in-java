package xyz.vimtool.chapter11.section9;

import xyz.vimtool.chapter18.section7.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class UniqueWords {

    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(new TextFile("core/src/main/java/xyz/vimtool/chapter11/section9/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
