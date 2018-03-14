package xyz.vimtool.chapter20.section5;

import xyz.vimtool.chapter20.section1.Test;

import java.util.HashSet;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class HashSetTest {

    HashSet<String> testObject = new HashSet<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add("one");
    }

    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/HashSetTest"};
        AtUnit.mainProcess(sl);
    }
}
