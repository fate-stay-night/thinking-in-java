package xyz.vimtool.chapter20.section5;

import net.mindview.util.OSExecute;
import xyz.vimtool.chapter20.section1.Test;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class AtUnitComposition {

    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/AtUnitComposition"};
        AtUnit.mainProcess(sl);
    }
}
