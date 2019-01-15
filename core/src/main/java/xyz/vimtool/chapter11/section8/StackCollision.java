package xyz.vimtool.chapter11.section8;

/**
 * 栈类对比
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class StackCollision {

    public static void main(String[] args) {
        String string = "My dog has fleas";

        Stack<String> stack1 = new Stack<>();
        for (String s : string.split(" ")) {
            stack1.push(s);
        }

        while (!stack1.empty()) {
            System.out.print(stack1.pop() + " ");
        }

        System.out.println();

        java.util.Stack<String> stack2 = new java.util.Stack<>();
        for (String s : string.split(" ")) {
            stack2.push(s);
        }

        while (!stack2.empty()) {
            System.out.print(stack2.pop() + " ");
        }
    }
}