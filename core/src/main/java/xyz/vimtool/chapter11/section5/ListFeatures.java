package xyz.vimtool.chapter11.section5;

import xyz.vimtool.chapter14.section3.*;

import java.util.*;

/**
 * List比较
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/15
 */
public class ListFeatures {

    public static void main(String[] args) {
        Random random = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1 : " + pets);

        Hamster hamster = new Hamster();
        pets.add(hamster);
        System.out.println("2 : " + pets);
        System.out.println("3 : " + pets.contains(hamster));

        pets.remove(hamster);
        Pet pet = pets.get(2);
        System.out.println("4 : " + pet + " " + pets.indexOf(pet));

        Pet cymric = new Cymric();
        System.out.println("5 : " + pets.indexOf(cymric));
        System.out.println("6 : " + pets.remove(cymric));
        System.out.println("7 : " + pets.remove(pet));
        System.out.println("8 : " + pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList : " + sub);
        System.out.println("10 : " + pets.containsAll(sub));

        Collections.sort(sub);
        System.out.println("sorted subList : " + sub);
        System.out.println("11 : " + pets.containsAll(sub));

        Collections.shuffle(sub, random);
        System.out.println("shuffled subList : " + sub);
        System.out.println("12 : " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub : " + sub);

        copy.retainAll(sub);
        System.out.println("13 : " + copy);

        copy = new ArrayList<>(pets);
        copy.remove(2);
        System.out.println("14 : " + copy);

        copy.retainAll(sub);
        System.out.println("15 : " + copy);

        copy.set(1, new Mouse());
        System.out.println("16 : " + copy);

        copy.addAll(2, sub);
        System.out.println("17 : " + copy);
        System.out.println("18 : " + pets.isEmpty());

        pets.clear();
        System.out.println("19 : " + pets);
        System.out.println("20 : " + pets.isEmpty());

        pets.addAll(Pets.arrayList(4));
        System.out.println("21 : " + pets);

        Object[] o = pets.toArray();
        System.out.println("22 : " + o[3]);

        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23 : " + pa[3].id());
    }
}
