package xyz.vimtool.chapter4.section4;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class ForEachString {

    public static void main(String[] args) {
        for (char c : "An African Swallow".toCharArray()){
            System.out.print(c + " ");
        }
    }
}
