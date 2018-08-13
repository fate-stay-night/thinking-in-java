package xyz.vimtool.chapter7.section8;

/**
 * final参数
 * final参数表明在方法中无法更改参数引用所指向的对象
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class FinalArguments {

    void with(final Gizmo gizmo) {
        // final对象引用不可改变
//        gizmo = new Gizmo();
    }

    void without(Gizmo gizmo) {
        gizmo = new Gizmo();
        gizmo.spin();
    }

    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.without(null);
        finalArguments.with(null);
    }
}

class Gizmo {

    public void spin() {}
}