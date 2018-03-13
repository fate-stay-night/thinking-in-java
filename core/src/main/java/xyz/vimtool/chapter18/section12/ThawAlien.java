package xyz.vimtool.chapter18.section12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 序列化寻找类
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class ThawAlien {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("X.file"));
        Object mystery = in.readObject();
        Class<?> aClass = mystery.getClass();
        System.out.println(aClass);
    }
}
