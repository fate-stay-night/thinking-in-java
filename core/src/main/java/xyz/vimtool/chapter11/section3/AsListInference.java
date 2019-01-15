package xyz.vimtool.chapter11.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/13
 */
public class AsListInference {

    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        List<Snow> snows2 = Arrays.asList(new Light(), new Heavy());

        List<Snow> snows3 = new ArrayList<>();
        Collections.addAll(snows3, new Light(), new Heavy());
    }
}

class Snow {}

class Powder extends Snow {}

class Light extends Powder {}

class Heavy extends Powder {}

class Crusty extends Snow {}

class Slush extends Snow {}