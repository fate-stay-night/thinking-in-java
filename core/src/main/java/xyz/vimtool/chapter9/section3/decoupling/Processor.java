package xyz.vimtool.chapter9.section3.decoupling;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/15
 */
public interface Processor {

    String name();

    Object process(Object input);
}
