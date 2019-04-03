package xyz.vimtool.chapter14.section3;

import java.util.ArrayList;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public class Pets {

    public static final PetCreator CREATOR = new LiteralPetCreator();

    public static Pet randomPet() {
        return CREATOR.randomPet();
    }

    public static Pet[] createArray(int size) {
        return CREATOR.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return CREATOR.arrayList(size);
    }
}
