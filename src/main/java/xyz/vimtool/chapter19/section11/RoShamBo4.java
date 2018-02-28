package xyz.vimtool.chapter19.section11;

import static xyz.vimtool.chapter19.section11.Outcome.DRAW;
import static xyz.vimtool.chapter19.section11.Outcome.LOSE;
import static xyz.vimtool.chapter19.section11.Outcome.WIN;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-28
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {

    ROCK {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return (opponent == this) ? Outcome.DRAW : ((opponent == loser) ? Outcome.WIN : Outcome.LOSE);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
