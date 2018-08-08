package xyz.vimtool.chapter3.section6;

/**
 * 自动递增和递减
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class AutoInc {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("i : " + i);
        System.out.println("++i : " + (++i));
        System.out.println("i++ : " + (i++));
        System.out.println("i : " + i);

        System.out.println("--i : " + (--i));
        System.out.println("i-- : " + (i--));
        System.out.println("i : " + i);
    }
}
