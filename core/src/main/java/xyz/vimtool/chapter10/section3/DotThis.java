package xyz.vimtool.chapter10.section3;

/**
 * 使用.this与.new
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class DotThis {

    void f() {
        System.out.println("DotThis.f()");
    }

    /**
     * 内部类
     */
    public class Inner {

        public DotThis outer() {
            // 外部类对象
            return DotThis.this;
        }
    }

    /**
     * 内部类对象
     */
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        inner.outer().f();
    }
}
