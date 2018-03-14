package xyz.vimtool.chapter20.section5;

import net.mindview.util.OSExecute;
import xyz.vimtool.chapter20.section1.Test;

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

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    //shows output for failure:
    @Test
    boolean failureTest() {
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        return false;
    }

    public static void main(String[] args) {
        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/AtUnitExample1"};
        AtUnit.mainProcess(sl);
    }
}
