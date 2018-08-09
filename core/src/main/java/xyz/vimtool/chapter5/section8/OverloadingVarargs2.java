package xyz.vimtool.chapter5.section8;

/**
 * 重载可变参数函数编译不过的情况
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

//    static void f(Character... args) {
//        System.out.println("second");
//    }

    static void f(char c, Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1, 'a');
        f('a', 'b');
    }
}
