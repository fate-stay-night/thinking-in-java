package xyz.vimtool.chapter11.section8;

import java.util.LinkedList;

/**
 * 用LinkedList实现栈
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<>();

    /**
     * 进栈
     * @param v
     */
    public void push(T v) {
        storage.addFirst(v);
    }

    /**
     * 查看栈顶
     */
    public T peek() {
        return storage.getFirst();
    }

    /**
     * 出栈
     */
    public T pop() {
        return storage.removeFirst();
    }

    /**
     * 空
     */
    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
