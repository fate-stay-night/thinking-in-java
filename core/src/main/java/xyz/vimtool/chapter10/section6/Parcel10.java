package xyz.vimtool.chapter10.section6;

import xyz.vimtool.chapter10.section4.Destination;

/**
 * 匿名类实例初始化
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel10 {

    public Destination destination(String dest, float price) {
        return new Destination() {

            private int cost;

            private String label = dest;

            // 实例初始化 -> 构造器
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget");
                }
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("Tasmania", 101.395F);
    }
}
