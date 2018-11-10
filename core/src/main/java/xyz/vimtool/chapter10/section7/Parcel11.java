package xyz.vimtool.chapter10.section7;

import xyz.vimtool.chapter10.section4.Contents;
import xyz.vimtool.chapter10.section4.Destination;

/**
 * 嵌套类（静态内部类）
 * 要创建嵌套类的对象，并不需要其外围类的对象
 * 不能从嵌套类的对象中访问非静态的外部类对象
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel11 {

    private static class ParcelContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {

        private String label;

        private ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {}

        static int x = 10;

        static class AnotherLevel {

            public static void f() {}

            static int x = 10;
        }

    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return  new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("Tasmania");
    }
}
