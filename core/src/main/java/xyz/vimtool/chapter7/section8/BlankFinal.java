package xyz.vimtool.chapter7.section8;

/**
 * 空白final
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class BlankFinal {

    private final int i = 0;

    private final int j;

    private final Poppet poppet;

    public BlankFinal() {
        j = 1;
        poppet = new Poppet(1);
    }

    public BlankFinal(int x) {
        j = 1;
        poppet = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}

class Poppet {

    private int i;

    Poppet(int ii) {
        i = ii;
    }
}