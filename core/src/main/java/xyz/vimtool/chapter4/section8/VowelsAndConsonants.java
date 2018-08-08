package xyz.vimtool.chapter4.section8;

import java.util.Random;

/**
 * switch
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/8
 */
public class VowelsAndConsonants {

    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.print((char) c + ", " );

            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }
}
