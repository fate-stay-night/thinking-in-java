package xyz.vimtool.chapter7.section8;

/**
 * final类
 * final类不能被继承，final类中所有的方法都隐式指定为final
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class Jurassic {

    public static void main(String[] args) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.f();
        dinosaur.i = 40;
        System.out.println(dinosaur.i);
        dinosaur.j++;
        System.out.println(dinosaur.j);
    }
}

class SmallBrain {}

final class Dinosaur {

    int i = 7;

    int j = 1;

    SmallBrain x = new SmallBrain();

    void f() {}
}

// final类不能被继承
//class Further extends Dinosaur {}