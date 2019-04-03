package xyz.vimtool.chapter14.section6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 类方法提取器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class ShowMethods {

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(ShowMethods.class.getName());
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();

            for (Method method : methods) {
                System.out.println(method.toString());
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }

            for (Constructor ctor : ctors) {
                System.out.println(ctor.toString());
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
