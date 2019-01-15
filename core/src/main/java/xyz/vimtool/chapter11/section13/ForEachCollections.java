package xyz.vimtool.chapter11.section13;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * foreach语句
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class ForEachCollections {

    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));

        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
    }
}
