package xyz.vimtool.chapter10.section1;

/**
 * 创建内部类
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/26
 */
public class Parcel1 {

    class Contents {

        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {

        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    /**
     * 使用内部类和其他类相似
     */
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
