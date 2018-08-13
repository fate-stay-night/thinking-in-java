package xyz.vimtool.chapter7.section7;

/**
 * 在继承中，新类是现有类的一种类型
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class Wind extends Instrument {

    public static void main(String[] args) {
        Wind wind = new Wind();

        // 向上转型
        Instrument.tune(wind);
    }
}

class Instrument {

    public void play() {}

    static void tune(Instrument instrument) {
        instrument.play();
    }
}
