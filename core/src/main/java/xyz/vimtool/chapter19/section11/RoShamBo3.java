package xyz.vimtool.chapter19.section11;

import static xyz.vimtool.chapter19.section11.Outcome.DRAW;
import static xyz.vimtool.chapter19.section11.Outcome.LOSE;
import static xyz.vimtool.chapter19.section11.Outcome.WIN;

/**
 * 使用常量相关的方法
 * 将enum用在switch语句中
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-28
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 item) {
            switch (item) {
                default:
                case PAPER:
                    return DRAW;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return LOSE;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 item) {
            switch (item) {
                default:
                case PAPER:
                    return WIN;
                case SCISSORS:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 item) {
            switch (item) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    public abstract Outcome compete(RoShamBo3 item);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
