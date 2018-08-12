package xyz.vimtool.chapter6.section2;

import xyz.vimtool.chapter6.section2.dessert.Cookie;

/**
 * public访问权限
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class Dinner {

    public static void main(String[] args) {
        Cookie cookie = new Cookie();

        // 不在同一包内的类，非public方法不可访问
//        cookie.bite();
    }
}
