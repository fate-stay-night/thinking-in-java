package xyz.vimtool.chapter13.section5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 十六进制转储工具
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    private static byte[] read(String fileName) {
        try(BufferedInputStream bf = new BufferedInputStream(new FileInputStream(new File(fileName)))) {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } catch (Exception e) {
            System.out.println(e);
            return "".getBytes();
        }
    }

    public static void main(String[] args) {
        System.out.println(format("string".getBytes()));

        System.out.println(format(read("core/src/main/java/xyz/vimtool/chapter13/section5/Hex.java")));
    }
}
