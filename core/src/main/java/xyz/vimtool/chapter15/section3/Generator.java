package xyz.vimtool.chapter15.section3;

/**
 * 生成器接口
 * 工厂方法设计模式的一种应用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/31
 */
public interface Generator<T> {

    /**
     * 生成下个元素
     *
     * @return T
     */
    T next();
}
