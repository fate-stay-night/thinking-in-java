package xyz.vimtool.chapter19.section6;

/**
 * 随机选取枚举值
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */

enum Activity {
    SITTING,
    LYING,
    STANDING,
    HOPPING,
    RUNNING,
    DODGING,
    JUMPING,
    FALLING,
    FLYING,;
}

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
