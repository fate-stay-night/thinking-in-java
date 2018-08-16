package xyz.vimtool.chapter9.section3.coupling;

import java.util.Arrays;

/**
 * 完全解藕
 * 涉及到的设计模式：策略模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public class Apply {

    public static void process(Processor processor, Object object) {
        System.out.println("Using processor " + processor.name());
        System.out.println(processor.process(object));
    }

    public static String string = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new UpCase(), string);
        process(new DownCase(), string);
        process(new Splitter(), string);
    }
}

class Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class UpCase extends Processor {

    // 协变类型
    @Override
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Splitter extends Processor {

    @Override
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}