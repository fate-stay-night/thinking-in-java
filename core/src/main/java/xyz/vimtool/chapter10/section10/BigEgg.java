package xyz.vimtool.chapter10.section10;

/**
 * 内部类被覆盖是完全不起作用的
 * 俩个内部类是完全独立的两个实体
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class BigEgg extends Egg {

    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}

class Egg {

    private Yolk yolk;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        yolk = new Yolk();
    }
}