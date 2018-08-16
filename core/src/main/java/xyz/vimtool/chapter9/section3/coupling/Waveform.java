package xyz.vimtool.chapter9.section3.coupling;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public class Waveform {

    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}