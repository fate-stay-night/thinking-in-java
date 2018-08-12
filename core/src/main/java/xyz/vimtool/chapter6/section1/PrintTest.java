package xyz.vimtool.chapter6.section1;

import static xyz.vimtool.chapter6.section1.Print.print;

/**
 * 测试Print类方法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class PrintTest {

    public static void main(String[] args) {
        print("Available from now on!");
        print(100);
        print(100L);
        print(3.14159);
    }
}
