package xyz.vimtool.chapter8.section3;

/**
 * 构造器内部的多态方法的行为
 * 初始化顺序：
 * 1 在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零/null
 * 2 如前所述那样调用基类构造器
 * 3 按照声明的顺序调用成员的初始化方法
 * 4 调用导出类的构造器主体
 *
 * 编写构造器准则：用尽可能简单的方法使对象进入正常状态；如果可以的话，避免调用其他方法
 *
 * 在构造器中唯一能够安全调用的方法是基类中的final方法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph {

    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}