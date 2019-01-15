package xyz.vimtool.chapter11.section6;

import xyz.vimtool.chapter14.section3.Pet;
import xyz.vimtool.chapter14.section3.Pets;

import java.util.*;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public class CrossContainerIteration {

    public static void display(Iterator<Pet> iterator) {
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petLinkedList = new LinkedList<>(pets);
        HashSet<Pet> petHashSet = new HashSet<>(pets);
        TreeSet<Pet> petTreeSet = new TreeSet<>(pets);
        display(pets.iterator());
        display(petLinkedList.iterator());
        display(petHashSet.iterator());
        display(petTreeSet.iterator());
    }
}
