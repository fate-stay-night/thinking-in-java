package xyz.vimtool.chapter19.section8;

import java.util.EnumSet;

import static net.mindview.util.Print.print;
import static xyz.vimtool.chapter19.section8.AlarmPoints.*;

/**
 * EnumSet代替标志的使用示例
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */
public class EnumSets {

    public static void main(String[] args) {
        //Empty set
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);

        points.add(BATHROOM);
        print(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}
