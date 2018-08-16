package xyz.vimtool.chapter9.section3.decoupling;

import xyz.vimtool.chapter9.section3.coupling.*;

/**
 * 适配器模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public class FilterProcessor {

    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveform);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), waveform);
    }
}

class FilterAdapter implements Processor {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}