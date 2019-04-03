package xyz.vimtool.chapter14.section2;

/**
 * 类加载
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-27
 */
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After create Candy");

        try {
            String name = Gum.class.getName();
            System.out.printf("Class Gum name is %s\n", name);
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After creating Cookie");
    }
}

class Candy {

    static {
        System.out.println("Loading Candy");
    }
}

class Gum {

    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {

    static {
        System.out.println("Loading Cookie");
    }
}