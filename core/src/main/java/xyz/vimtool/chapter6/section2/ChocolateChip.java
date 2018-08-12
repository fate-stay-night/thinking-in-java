package xyz.vimtool.chapter6.section2;

import xyz.vimtool.chapter6.section2.dessert.Cookie;

/**
 * protected访问权限
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        // 访问不了包权限的方法
//        this.bite();
    }

    public void chomp1() {
        // 可以访问protected权限的方法
        this.bite1();
    }

    public static void main(String[] args) {
        ChocolateChip chip = new ChocolateChip();
        chip.chomp();
        chip.chomp1();
    }
}
