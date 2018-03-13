package xyz.vimtool.chapter20.section5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-13
 */
public class AtUnitExample4 {

    static String theory = "All brontosauruses are thin at one end, much MUCH thicker in the" +
            "middle, and then thin again at the far end.";

    private String word;

    private Random random = new Random();//Time based seed

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String scrambleWord() {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            chars.add(c);
        }

        Collections.shuffle(chars, random);
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            result.append(ch);
        }

        return result.toString();
    }
}
