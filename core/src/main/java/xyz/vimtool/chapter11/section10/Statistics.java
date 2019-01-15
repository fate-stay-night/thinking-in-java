package xyz.vimtool.chapter11.section10;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Map应用
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class Statistics {

    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
