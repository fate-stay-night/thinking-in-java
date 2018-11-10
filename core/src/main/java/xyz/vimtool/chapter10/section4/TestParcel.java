package xyz.vimtool.chapter10.section4;

/**
 * 内部类与向上转型
 * 私有内部类只有外围类能够访问
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class TestParcel {

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        Destination destination = parcel4.destination("Tasmania");
    }
}

class Parcel4 {

    private class PContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String label;

        private PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Contents contents() {
        return new PContents();
    }

    public Destination destination(String label) {
        return new PDestination(label);
    }
}