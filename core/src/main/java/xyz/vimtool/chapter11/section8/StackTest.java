package xyz.vimtool.chapter11.section8;

/**
 * 栈测试
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String string = "My dog has fleas";
        for (String s : string.split(" ")) {
            stack.push(s);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
