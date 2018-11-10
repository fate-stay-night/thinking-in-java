package xyz.vimtool.chapter10.section5;

/**
 * 在任意的作用域内嵌入一个内部类
 * 定义在作用域内的类，此作用域在方法的内部
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class Parcel6 {

    private void internalTracking(boolean b) {
        if (b) {

            /**
             * 该类的创建与if语句条件无关，在一开始就和其他类一起编译了
             */
            class TrackingSlip {

                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }

            TrackingSlip slip = new TrackingSlip("slip");
            String s = slip.getSlip();
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
