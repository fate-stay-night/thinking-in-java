package xyz.vimtool.chapter20.section5;

import xyz.vimtool.chapter20.section1.Test;

/**
 * 测试String版的堆栈
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-14
 */
public class StackLStringTest extends StackL<String> {

    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) {
        String path0 = StackLStringTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String path1 = StackLStringTest.class.getClassLoader().getResource("").getPath();
        String path2 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String path3 = ClassLoader.getSystemResource("").getPath();
        System.out.println(path0);
        System.out.println(path1);
        System.out.println(path2);
        System.out.println(path3);

        String[] sl = {path0 + "xyz/vimtool/chapter20/section5/StackLStringTest"};
        AtUnit.mainProcess(sl);
    }
}
