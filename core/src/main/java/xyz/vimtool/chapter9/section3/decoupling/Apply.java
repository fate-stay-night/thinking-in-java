package xyz.vimtool.chapter9.section3.decoupling;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public class Apply {

    public static void process(Processor processor, Object object) {
        System.out.println("Using Processor " + processor.name());
        System.out.println(processor.process(object));
    }
}
