package xyz.vimtool.chapter7.section2;

/**
 * 带参数的构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class Chess extends BoardGame {

    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}

class Game {

    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}