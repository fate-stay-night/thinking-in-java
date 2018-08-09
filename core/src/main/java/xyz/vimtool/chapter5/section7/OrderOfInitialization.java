package xyz.vimtool.chapter5.section7;

/**
 * 初始化顺序
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class OrderOfInitialization {

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}

class Window {

    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {

    Window w1 = new Window(1);

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}
