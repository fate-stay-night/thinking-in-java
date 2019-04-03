package xyz.vimtool.chapter14.section2;

/**
 * 泛化的Class引用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;

        genericIntClass = Integer.class;
        intClass = double.class;
    }
}
