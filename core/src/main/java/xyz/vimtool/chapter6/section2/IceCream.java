package xyz.vimtool.chapter6.section2;

/**
 * private访问权限
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class IceCream {

    public static void main(String[] args) {
//        Sundae sundae = new Sundae();
        Sundae sundae = Sundae.makeASundae();
    }
}

class Sundae {

    private Sundae() {}

    static Sundae makeASundae() {
        return new Sundae();
    }
}
