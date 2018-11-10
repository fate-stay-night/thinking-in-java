package xyz.vimtool.chapter10.section7;

/**
 * 利用嵌套类放置测试代码
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/10/27
 */
public class TestBed {

    public void f() {
        System.out.println("f()");
    }

    public static class Tester {

        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}
