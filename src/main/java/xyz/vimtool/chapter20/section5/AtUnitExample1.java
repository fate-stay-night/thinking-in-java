package xyz.vimtool.chapter20.section5;

/**
 * 注解的单元测试
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-9
 */
public class AtUnitExample1 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
}
