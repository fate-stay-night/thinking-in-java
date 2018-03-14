package xyz.vimtool.chapter20.section5;

import java.util.LinkedList;

/**
 * 将@Unit用于泛型
 *
 * @author zhangzheng
 * @version 1.0
 * @date 2018-3-14
 * @since jdk1.8
 */
public class StackL<T> {

    private LinkedList<T> linkedList = new LinkedList<>();

    public void push(T v) {
        linkedList.addFirst(v);
    }

    public T top() {
        return linkedList.getFirst();
    }

    public T pop() {
        return linkedList.removeFirst();
    }
}