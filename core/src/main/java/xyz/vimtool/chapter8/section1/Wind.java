package xyz.vimtool.chapter8.section1;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Wind extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}

class Instrument {

    public void play(Note note) {
        System.out.println("Instrument.play()");
    }
}