package xyz.vimtool.chapter10.section6;

import xyz.vimtool.chapter10.section4.Contents;

/**
 * 匿名内部类
 * 实现了接口的匿名类，这里匿名类使用默认构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel7 {

    public Contents contents() {

        // 创建一个继承自Contents的匿名类的对象
        return new Contents() {

            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
    }
}
