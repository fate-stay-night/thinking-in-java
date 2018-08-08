package xyz.vimtool.chapter2.section7;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 显示属性
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/7
 */
public class ShowProperties {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String propertyName = (String)enumeration.nextElement();
            System.out.println(propertyName + "=" + System.getProperty(propertyName));
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");

        properties.list(System.out);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.runtime.version"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
