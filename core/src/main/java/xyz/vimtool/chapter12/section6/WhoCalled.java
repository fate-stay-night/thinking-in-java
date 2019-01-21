package xyz.vimtool.chapter12.section6;

/**
 * 栈轨迹
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class WhoCalled {

    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println(element.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }
    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("-------------------------------------------");
        g();
        System.out.println("-------------------------------------------");
        h();
        System.out.println("-------------------------------------------");
    }
}
