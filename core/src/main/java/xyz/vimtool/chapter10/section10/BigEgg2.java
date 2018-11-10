package xyz.vimtool.chapter10.section10;

/**
 * 这里明确的继承某个内部类
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class BigEgg2 extends Egg2 {

    public class Yolk extends Egg2.Yolk {

        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        BigEgg2 bigEgg2 = new BigEgg2();
        bigEgg2.g();
    }
}

class Egg2 {

    protected class Yolk {

        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }

    private Yolk yolk = new Yolk();

    public Egg2() {
        System.out.println("New Egg2()");
    }

    public void insertYolk(Yolk yolk) {
        this.yolk = yolk;
    }

    public void g() {
        yolk.f();
    }
}