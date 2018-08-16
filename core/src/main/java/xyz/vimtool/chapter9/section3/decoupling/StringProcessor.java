package xyz.vimtool.chapter9.section3.decoupling;

import java.util.Arrays;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public abstract class StringProcessor implements Processor {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);

    public static String string = "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new UpCase(), string);
        Apply.process(new DownCase(), string);
        Apply.process(new Splitter(), string);
    }
}

class UpCase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}