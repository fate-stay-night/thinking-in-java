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

    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
