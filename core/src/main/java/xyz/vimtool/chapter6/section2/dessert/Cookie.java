package xyz.vimtool.chapter6.section2.dessert;

/**
 * public访问权限
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class Cookie {

    public Cookie() {
        System.out.println("Cookie construct");
    }

    void bite() {
        System.out.println("bite");
    }

    protected void bite1() {
        System.out.println("bite1");
    }
}
