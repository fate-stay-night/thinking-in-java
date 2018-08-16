package xyz.vimtool.chapter9.section9;

/**
 * 创建框架的基础
 * 示例：在相同的棋盘上下国际象棋和西洋跳棋
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class Games {

    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()) {}
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }
}

interface Game {

    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {

    private int moves = 0;

    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {

    private int moves = 0;

    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Chess();
    }
}