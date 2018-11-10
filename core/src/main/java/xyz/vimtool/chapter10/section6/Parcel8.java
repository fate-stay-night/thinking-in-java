package xyz.vimtool.chapter10.section6;

/**
 * 一个匿名类，它扩展了有非默认构造器的类
 * 匿名内部类，使用有参数的构造器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel8 {

    public Wrapping wrapping(int x) {

        return new Wrapping(x) {

            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(10);
    }
}
