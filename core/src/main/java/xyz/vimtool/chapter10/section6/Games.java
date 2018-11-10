package xyz.vimtool.chapter10.section6;

/**
 * 9.9节游戏示例的改进
 * 工厂类直接使用匿名类
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Games {


    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()) {}
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
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

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class Chess implements Game {

    private int moves = 0;

    private static final int MOVES = 4;

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}