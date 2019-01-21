package xyz.vimtool.chapter12.section8;

/**
 * finally字句中资源释放
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class Switch {

    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}