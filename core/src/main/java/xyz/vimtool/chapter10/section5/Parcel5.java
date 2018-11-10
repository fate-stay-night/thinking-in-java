package xyz.vimtool.chapter10.section5;

import xyz.vimtool.chapter10.section4.Destination;

/**
 * 定义在方法中的类:局部内部类
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel5 {

    public Destination destination(String label) {

        class PDestination implements Destination {

            private String label;

            private PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(label);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("Tasmania");
    }
}
