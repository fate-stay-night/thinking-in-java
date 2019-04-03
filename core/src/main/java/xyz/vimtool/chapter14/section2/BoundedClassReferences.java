package xyz.vimtool.chapter14.section2;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class BoundedClassReferences {

    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
