package xyz.vimtool.chapter14.section9;

import java.lang.reflect.Field;

/**
 * 反射访问
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-04-03
 */
public class ModifyingPrivateFields {

    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        Field field = pf.getClass().getDeclaredField("i");
        field.setAccessible(true);
        System.out.println("field.getInt(pf): " + field.getInt(pf));

        field.setInt(pf, 47);
        System.out.println(pf);

        field = pf.getClass().getDeclaredField("s");
        field.setAccessible(true);
        System.out.println("field.get(pf): " + field.get(pf));

        field.set(pf, "No, you're not!");
        System.out.println(pf);

        field = pf.getClass().getDeclaredField("s2");
        field.setAccessible(true);
        System.out.println("field.get(pf): " + field.get(pf));

        field.set(pf, "No, you're not!");
        System.out.println(pf);
    }
}

class WithPrivateFinalField {
    private int i = 1;

    private final String s = "I'm totally safe";

    private String s2 = "Am I safe?";

    @Override
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}