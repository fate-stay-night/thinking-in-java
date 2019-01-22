package xyz.vimtool.chapter13.section5;

/**
 * 简单的输出格式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class SimpleFormat {

    public static void main(String[] args) {
        int x = 5;
        double y = 5.314525;

        System.out.println("Row 1 : [" + x + " " + y + "]");
        System.out.format("Row 1 : [%d %f]\n", x, y);
        System.out.printf("Row 1 : [%d %f]\n", x, y);
    }
}
