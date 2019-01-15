package xyz.vimtool.chapter11.section9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Set操作
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class SetOperations {

    public static void main(String[] args) {
        String string1 = "A B C D E F G H I J K L";
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1, string1.split(" "));
        set1.add("M");
        System.out.println("H : " + set1.contains("H"));
        System.out.println("N : " + set1.contains("N"));

        String string2 = "H I J K L";
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, string2.split(" "));
        System.out.println("set2 in set1 : " + set1.containsAll(set2));
        set1.remove("H");
        System.out.println("set1 : " + set1);
        System.out.println("set2 in set1 : " + set1.containsAll(set2));
        set1.removeAll(set2);
        System.out.println("set2 removed from set1 : " + set1);

        String string3 = "X Y Z";
        Collections.addAll(set1, string3.split(" "));
        System.out.println("'X Y Z' added to set1 : " + set1);
    }
}
