package xyz.vimtool.chapter8.section5;

/**
 * 用继承进行设计时，首先考虑使用组合
 * 通用准则：用继承表达行为间的差异，并用字段表达状态上的变化
 *
 * 使用了设计模式的状态模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class Transmogrify {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

class Actor {

    public void act() {}
}

class HappyActor extends Actor {

    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {

    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {

    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}