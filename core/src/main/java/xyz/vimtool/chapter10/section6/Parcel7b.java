package xyz.vimtool.chapter10.section6;

import xyz.vimtool.chapter10.section4.Contents;

/**
 * 匿名类的原来形式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel7b {

    class MyContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b parcel7b = new Parcel7b();
        parcel7b.contents();
    }
}
