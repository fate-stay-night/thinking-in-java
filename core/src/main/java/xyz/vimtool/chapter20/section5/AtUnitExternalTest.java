package xyz.vimtool.chapter20.section5;

import xyz.vimtool.chapter20.section1.Test;

/**
 * 利用继承生成一个非嵌入式的测试
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class AtUnitExternalTest extends AtUnitExample1 {

    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/AtUnitExternalTest"};
        AtUnit.mainProcess(sl);
    }
}
