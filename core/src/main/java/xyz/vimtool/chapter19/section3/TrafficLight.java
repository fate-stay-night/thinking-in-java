package xyz.vimtool.chapter19.section3;

/**
 * switch语句中使用用enum
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-9
 */

enum Signal {
    GREEN,
    YELLOW,
    RED,
}

public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            //note that you don't have to say Signal.RED
            //in the case statement
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
