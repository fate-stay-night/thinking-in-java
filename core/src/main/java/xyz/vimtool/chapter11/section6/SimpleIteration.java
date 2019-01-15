package xyz.vimtool.chapter11.section6;

import xyz.vimtool.chapter14.section3.Pet;
import xyz.vimtool.chapter14.section3.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();

        for (Pet pet : pets) {
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();

        iterator = pets.iterator();
        for (int i = 0; i < 6; i++) {
            // 调用remove之前必须先调用next
            iterator.next();
            iterator.remove();
        }
        System.out.println(pets);
    }
}
