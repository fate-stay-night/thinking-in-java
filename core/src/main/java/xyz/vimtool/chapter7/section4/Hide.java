package xyz.vimtool.chapter7.section4;

/**
 * 子类方法重新定义不会覆盖基类方法，重载机制依旧有效
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class Hide {

    public static void main(String[] args) {
        Bart bart = new Bart();
        bart.doh(1);
        bart.doh('x');
        bart.doh(1.0f);
        bart.doh(new Milhouse());
    }
}

class Homer {

    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {

    void doh(Milhouse milhouse) {
        System.out.println("doh(milhouse)");
    }
}