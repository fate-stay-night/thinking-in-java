package xyz.vimtool.chapter7.section1;

/**
 * 综合语法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class SprinklerSystem {

    private String value1;

    private String value2;

    private String value3;

    private String value4;

    private WaterSource source = new WaterSource();

    private int i;

    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}

class WaterSource {

    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return this.s;
    }
}