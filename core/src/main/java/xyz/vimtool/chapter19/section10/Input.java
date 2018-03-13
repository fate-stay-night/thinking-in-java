package xyz.vimtool.chapter19.section10;

import java.util.Random;

/**
 * 使用enum的状态机，以自动售货机为例
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-27
 */
public enum Input {

    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100),
    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;

    Input() {}

    Input(int value) {
        this.value = value;
    }

    int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection() {
        //don't include STOP
        return values()[random.nextInt(values().length - 1)];
    }
}
