package xyz.vimtool.chapter13.section5;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Formatter转换
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class Conversion {

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        
        char u = 'a';
        System.out.println("u = 'a'");
        formatter.format("s: %s\n", u);
//        formatter.format("d: %d\n", u);
        formatter.format("c: %c\n", u);
        formatter.format("b: %b\n", u);
//        formatter.format("f: %f\n", u);
//        formatter.format("e: %e\n", u);
//        formatter.format("x: %x\n", u);
        formatter.format("h: %h\n", u);
        
        int v = 121;
        System.out.println("v = 121");
        formatter.format("d: %d\n", v);
        formatter.format("c: %c\n", v);
        formatter.format("b: %b\n", v);
        formatter.format("s: %s\n", v);
//        formatter.format("f: %f\n", v);
//        formatter.format("e: %e\n", v);
        formatter.format("x: %x\n", v);
        formatter.format("h: %h\n", v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("w = new BigInteger(\"50000000000000\")");
        formatter.format("d: %d\n", w);
//        formatter.format("c: %c\n", w);
        formatter.format("b: %b\n", w);
        formatter.format("s: %s\n", w);
//        formatter.format("f: %f\n", w);
//        formatter.format("e: %e\n", w);
        formatter.format("x: %x\n", w);
        formatter.format("h: %h\n", w);

        double x = 179.543;
        System.out.println("x = 179.543");
//        formatter.format("d: %d\n", x);
//        formatter.format("c: %c\n", x);
        formatter.format("b: %b\n", x);
        formatter.format("s: %s\n", x);
        formatter.format("f: %f\n", x);
        formatter.format("e: %e\n", x);
//        formatter.format("x: %x\n", x);
        formatter.format("h: %h\n", x);

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
//        formatter.format("d: %d\n", y);
//        formatter.format("c: %c\n", y);
        formatter.format("b: %b\n", y);
        formatter.format("s: %s\n", y);
//        formatter.format("f: %f\n", y);
//        formatter.format("e: %e\n", y);
//        formatter.format("y: %y\n", y);
        formatter.format("h: %h\n", y);

        boolean z = false;
        System.out.println("z = false");
//        formatter.format("d: %d\n", z);
//        formatter.format("c: %c\n", z);
        formatter.format("b: %b\n", z);
        formatter.format("s: %s\n", z);
//        formatter.format("f: %f\n", z);
//        formatter.format("e: %e\n", z);
//        formatter.format("z: %z\n", z);
        formatter.format("h: %h\n", z);
    }
}
