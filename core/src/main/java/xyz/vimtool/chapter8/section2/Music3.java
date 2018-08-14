package xyz.vimtool.chapter8.section2;

import xyz.vimtool.chapter8.section1.Note;

/**
 * 多态可扩展性
 * 向上转型
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Music3 {

    public static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
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

class Instrument {

    void play(Note note) {
        System.out.println("Instrument.play() " + note);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Percussion.play() " + note);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {

    @Override
    void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind {

    @Override
    void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Woodwind");
    }
}