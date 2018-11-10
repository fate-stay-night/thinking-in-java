package xyz.vimtool.chapter10.section7;

/**
 * 接口内部的类
 * 接口中的任何属性都自动地时public和static
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public interface ClassInInterface {

    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
