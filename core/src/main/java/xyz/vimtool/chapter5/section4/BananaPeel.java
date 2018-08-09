package xyz.vimtool.chapter5.section4;

/**
 * this关键字
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class BananaPeel {

    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}

class Banana {

    void peel(int i) {
        System.out.println(i);
    }
}
