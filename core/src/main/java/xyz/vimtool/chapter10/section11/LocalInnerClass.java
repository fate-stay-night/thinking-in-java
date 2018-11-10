package xyz.vimtool.chapter10.section11;

/**
 * 局部内部类：在代码块里创建的内部类
 * 局部内部类、匿名内部类：二者区别在于，当我们需要一个已命名的构造器或需要重载构造器时，而匿名类只能用于实例初始化
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {

        class LocalCounter implements Counter {

            public LocalCounter() {
                System.out.println("LocalCounter");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }

        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter counter1 = localInnerClass.getCounter("Local inner");
        Counter counter2 = localInnerClass.getCounter2("Anonymous inner");

        for (int i = 0; i < 5; i++) {
            System.out.println(counter1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(counter2.next());
        }
    }
}

interface Counter {
    int next();
}