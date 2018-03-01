package xyz.vimtool.chapter19.section11;

/**
 * 使用二位数组实现两路分发
 *
 * @author zhangzheng
 * @version 1.0
 * @date 2018-3-1
 * @since jdk1.8
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static Outcome[][] table = {
            { Outcome.DRAW, Outcome.LOSE, Outcome.WIN }, //PAPER
            { Outcome.LOSE, Outcome.WIN, Outcome.DRAW }, //SCISSORS
            { Outcome.WIN, Outcome.DRAW, Outcome.LOSE}   //ROCK
    };

    @Override
    public Outcome compete(RoShamBo6 competitor) {
        return table[this.ordinal()][competitor.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
