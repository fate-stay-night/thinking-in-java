package xyz.vimtool.chapter14.section2;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class GenericToyTest {

    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;

        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
