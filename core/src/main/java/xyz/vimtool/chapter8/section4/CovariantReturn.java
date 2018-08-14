package xyz.vimtool.chapter8.section4;

/**
 * 协变返回类型
 *
 * 在子类中被被覆盖方法可以返回基类方法的返回类型的某种子类型
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/14
 */
public class CovariantReturn {

    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain grain = mill.process();
        System.out.println(grain);

        WheatMill wheatMill = new WheatMill();
        Wheat wheat = wheatMill.process();
        System.out.println(wheat);
    }
}

class Grain {

    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {

    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {

    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {

    @Override
    Wheat process() {
        return new Wheat();
    }
}