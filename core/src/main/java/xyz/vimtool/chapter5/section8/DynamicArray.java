package xyz.vimtool.chapter5.section8;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class DynamicArray {

    public static void main(String[] args) {
        Other.main(new String[]{"fiddle", "de", "dum"});
    }
}

class Other {

    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s + " ");
        }
    }
}