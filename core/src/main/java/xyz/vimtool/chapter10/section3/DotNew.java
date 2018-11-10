package xyz.vimtool.chapter10.section3;

/**
 * 创建内部类的对象
 * 要想直接创建内部类的对象，需要使用外部类对象来创建；
 * 如果创建的是嵌套类（静态内部类），则不需要对外部类对象的引用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class DotNew {

    public class Inner {}

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner inner = dotNew.new Inner();
    }
}
