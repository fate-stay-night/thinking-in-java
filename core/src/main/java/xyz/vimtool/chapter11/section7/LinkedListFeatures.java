package xyz.vimtool.chapter11.section7;

import xyz.vimtool.chapter14.section3.Hamster;
import xyz.vimtool.chapter14.section3.Pet;
import xyz.vimtool.chapter14.section3.Pets;
import xyz.vimtool.chapter14.section3.Rat;

import java.util.LinkedList;

/**
 * LinkedList特性:可用作栈、队列、双端队列
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        System.out.println(pets);

        System.out.println("pets.getFirst() : " + pets.getFirst());
        System.out.println("pets.element() : " + pets.element());
        System.out.println("pets.peek() : " + pets.peek());

        System.out.println("pets.remove() : " + pets.remove());
        System.out.println("pets.removeFirst() : " + pets.removeFirst());
        System.out.println("pets.poll() : " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst() : " + pets);

        pets.offer(Pets.randomPet());
        System.out.println("After offer() : " + pets);

        pets.add(Pets.randomPet());
        System.out.println("After add() : " + pets);

        pets.addLast(new Hamster());
        System.out.println("After addLast() : " + pets);

        System.out.println("pets.removeLast() : " + pets.removeLast());
    }
}