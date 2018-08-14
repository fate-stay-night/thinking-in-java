package xyz.vimtool.chapter8.section5;

/**
 * 向下转型与运行时类型识别
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class RTTI {

    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();

        ((MoreUseful) x[1]).u();

        // 这里会抛转型失败异常
        ((MoreUseful) x[0]).u();
    }
}

class Useful {

    public void f() {}

    public void g() {}
}

class MoreUseful extends Useful {

    @Override
    public void f() {}

    @Override
    public void g() {}

    public void u() {}

    public void v() {}

    public void w() {}
}