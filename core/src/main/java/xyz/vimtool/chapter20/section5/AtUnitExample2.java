package xyz.vimtool.chapter20.section5;

import xyz.vimtool.chapter20.section1.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class AtUnitExample2 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void assertFailureExample() {
        assert  1 == 2 : "What a surprise";
    }

    @Test
    void exceptionExample() throws IOException {
        new FileInputStream("nofile.txt");
    }

    @Test
    boolean assertAndReturn() {
        //Assertion with message:
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) throws Exception {
        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/AtUnitExample2"};
        AtUnit.mainProcess(sl);
    }
}
