package xyz.vimtool.chapter9.section4;

/**
 * 多重继承
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
    }
}

interface CanFight {

    void fight();
}

interface CanSwim {

    void swim();
}

interface CanFly {

    void fly();
}

class ActionCharacter {

    public void fight() {}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {}

    @Override
    public void fly() {}
}