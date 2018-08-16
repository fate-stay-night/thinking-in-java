package xyz.vimtool.chapter9.section1;

import xyz.vimtool.chapter8.section1.Note;

/**
 * 抽象类和抽象方法
 * 使用抽象类修改管弦乐器示例
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Music4 {

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

abstract class Instrument {

    private int i;

    public abstract void play(Note note);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {}
}

class Percussion extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Percussion.play() " + note);
    }

    @Override
    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {}
}

class Stringed extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {}
}

class Brass extends Wind {

    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Brass.adjust()");
    }
}

class Woodwind extends Wind {

    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}