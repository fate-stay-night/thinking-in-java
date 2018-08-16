package xyz.vimtool.chapter9.section2;

import xyz.vimtool.chapter8.section1.Note;

/**
 * 接口
 * 接口中方法隐式为public，属性为static & final
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Music5 {

    static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] instruments = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(instruments);
    }
}

interface Instrument {

    int VALUE = 5;

    void play(Note note);

    void adjust();
}

class Wind implements Instrument {

    @Override
    public void play(Note note) {
        System.out.println(this + ".play() " + note);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Percussion implements Instrument {

    @Override
    public void play(Note note) {
        System.out.println(this + ".play() " + note);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Stringed implements Instrument {

    @Override
    public void play(Note note) {
        System.out.println(this + ".play() " + note);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Brass extends Wind {

    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {

    @Override
    public String toString() {
        return "Woodwind";
    }
}