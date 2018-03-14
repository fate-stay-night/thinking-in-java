package xyz.vimtool.chapter20.section5;

import xyz.vimtool.chapter20.section1.Test;

import java.util.*;

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

    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));

    @TestProperty
    static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext()) {
            return new AtUnitExample4(words.next());
        } else {
            return null;
        }
    }

    @Test
    boolean words() {
        System.out.println("'" + getWord() + "'");
        return getWord().equals("are");
    }

    @Test
    boolean scramble1() {
        //change to a specific seed to get verifiable results:
        random = new Random(47);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("lAl");
    }

    @Test
    boolean scramble2() {
        random = new Random(74);
        System.out.println("'" + getWord() + "'");
        String scrambled = scrambleWord();
        System.out.println(scrambled);
        return scrambled.equals("tsaeborornussu");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting");

        String[] sl = {ClassLoader.getSystemResource("").getPath()
                + "xyz/vimtool/chapter20/section5/AtUnitExample4"};
        AtUnit.mainProcess(sl);
    }
}
