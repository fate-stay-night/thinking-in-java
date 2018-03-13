package xyz.vimtool.chapter19.section4;

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * enum类中values
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-9
 */

enum Explore {
    HERE,
    THERE,
}

public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("---------- Analyzing " + enumClass + " ----------");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        TreeSet<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum) ? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(enumMethods) : ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        //Decompile the code for the enum
        OSExecute.command("javap Explore");
    }
}
