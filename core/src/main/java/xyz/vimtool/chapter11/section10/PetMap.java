package xyz.vimtool.chapter11.section10;

import xyz.vimtool.chapter14.section3.Cat;
import xyz.vimtool.chapter14.section3.Dog;
import xyz.vimtool.chapter14.section3.Hamster;
import xyz.vimtool.chapter14.section3.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class PetMap {

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>(3);
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);

        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
