package xyz.vimtool.chapter3.section4;

/**
 * 对象赋值
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class Assignment {

    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        System.out.println("1: t1.level: " + t1.level + ", t2.level: " + t2.level);

        t1 = t2;
        System.out.println("2: t1.level: " + t1.level + ", t2.level: " + t2.level);

        t1.level = 27;
        System.out.println("3: t1.level: " + t1.level + ", t2.level: " + t2.level);
    }
}

class Tank {
    int level;
}
