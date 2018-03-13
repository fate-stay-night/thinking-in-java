package xyz.vimtool.chapter19.section5;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * 枚举实现多个接口
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY,
    SPANKY,
    PUNCHY,
    SILLY,
    BOUNCY,
    NUTTY,
    BOB,;

    private Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;

        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
