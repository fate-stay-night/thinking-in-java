package xyz.vimtool.chapter9.section6;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 适配接口
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class RandomWords implements Readable {

    private static Random random = new Random(47);

    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final char[] lowers = "abcedfghijklmnopqrstuvwxyz".toCharArray();

    private static final char[] vowels = "aeiou".toCharArray();

    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }

        cb.append(capitals[random.nextInt(capitals.length)]);

        for (int i = 0; i < 4; i++) {
            cb.append(vowels[random.nextInt(vowels.length)]);
            cb.append(lowers[random.nextInt(lowers.length)]);
        }

        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomWords(10));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
