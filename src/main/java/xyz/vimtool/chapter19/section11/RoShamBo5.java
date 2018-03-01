package xyz.vimtool.chapter19.section11;

import java.util.EnumMap;

/**
 * EnumMap实现两路分发
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-1
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {

    PAPER, SCISSORS, ROCK;

    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<>(RoShamBo5.class);

    static {
        for (RoShamBo5 item : RoShamBo5.values()) {
            table.put(item, new EnumMap<>(RoShamBo5.class));
        }

        initRow(PAPER, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
        initRow(SCISSORS, Outcome.WIN, Outcome.DRAW, Outcome.LOSE);
        initRow(ROCK, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
    }

    static void initRow(RoShamBo5 item, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(item);

        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }

    @Override
    public Outcome compete(RoShamBo5 competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
