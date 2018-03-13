package xyz.vimtool.chapter20.section5;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.util.OSExecute;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class AtUnitExample3 {

    private int n;

    public AtUnitExample3(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @TestObjectCreate
    static AtUnitExample3 create() {
        return new AtUnitExample3(47);
    }

    @Test
    boolean initialization() {
        return n == 47;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindview.atunit.AtUnit AtUnitExample3");
    }
}
