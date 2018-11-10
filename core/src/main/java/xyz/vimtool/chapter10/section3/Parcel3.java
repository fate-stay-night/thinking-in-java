package xyz.vimtool.chapter10.section3;

/**
 * .new的应用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel3 {

    class Contents {

        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {

        private String label;

        Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Parcel3.Contents contents = parcel3.new Contents();
        Parcel3.Destination destination = parcel3.new Destination("Tasmania");
    }
}
