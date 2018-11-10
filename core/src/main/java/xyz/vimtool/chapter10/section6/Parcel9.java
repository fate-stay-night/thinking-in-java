package xyz.vimtool.chapter10.section6;

import xyz.vimtool.chapter10.section4.Destination;

/**
 * 在匿名类中定义字段时，对其进行初始化操作
 * 一个匿名类，它执行字段初始化
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel9 {

    /**
     * 这个方法传参的final可以去掉
     */
    public Destination destination(final String dest) {

        return new Destination() {

            // 字段初始化
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("Tasmania");
    }
}
