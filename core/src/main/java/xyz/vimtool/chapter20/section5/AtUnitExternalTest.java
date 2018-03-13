package xyz.vimtool.chapter20.section5;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

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
        OSExecute.command("java net.mindview.atunit.AtUnit AtUnitExternalTest");
    }
}
