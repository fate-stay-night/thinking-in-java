package xyz.vimtool.chapter7.section3;

/**
 * 太空船继承太空船控制模块
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class SpaceShip extends SpaceShipControls {

    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
