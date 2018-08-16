package xyz.vimtool.chapter9.section5;

/**
 * 通过继承来扩展接口
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);

        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}

interface Monster {

    void menace();
}

interface DangerousMonster extends Monster {

    void destroy();
}

interface Lethal {

    void kill();
}

class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {}

    @Override
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {

    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {}

    @Override
    public void destroy() {}

    @Override
    public void kill() {}

    @Override
    public void drinkBlood() {}
}