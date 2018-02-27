package xyz.vimtool.chapter19.section9;

import xyz.vimtool.chapter19.section8.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
import static xyz.vimtool.chapter19.section8.AlarmPoints.*;

/**
 * 使用EnumMap
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */

interface Command {
    void action();
}

public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> print("Kitchen fire!"));
        em.put(BATHROOM, () -> print("Bathroom alert!"));

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            //If there is no value for a particular key :
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}
