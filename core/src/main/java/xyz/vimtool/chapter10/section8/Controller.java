package xyz.vimtool.chapter10.section8;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理并出发事件的实际控制框架
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class Controller {

    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            // 这里是列表浅复制，列表中对象一样；深复制需要使用clone函数
            for (Event event : new ArrayList<>(eventList)) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}