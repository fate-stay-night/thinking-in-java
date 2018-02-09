package xyz.vimtool.chapter19.section1;

/**
 * 枚举类
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */

enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + "");
            System.out.println(s.equals(Shrubbery.CRAWLING) + "");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //produce an enum value from a string name
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }


    }
}
