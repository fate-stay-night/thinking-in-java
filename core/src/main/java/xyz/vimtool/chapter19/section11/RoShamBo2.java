package xyz.vimtool.chapter19.section11;

import static xyz.vimtool.chapter19.section11.Outcome.*;

/**
 * 使用enum分发，实现剪刀石头布游戏
 * 使用构造器来初始化每个enum实例，并以”一组“结果作为参数；
 * 这二者放在一起，形成类似查询表的结构
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-28
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {

    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private Outcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        vPAPER = paper;
        vSCISSORS = scissors;
        vROCK = rock;
    }

    public Outcome compete(RoShamBo2 item) {
        switch (item) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    public static void main(String[] args) {

        RoShamBo.play(RoShamBo2.class, 20);
    }
}
