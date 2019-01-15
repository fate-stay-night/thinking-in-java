package xyz.vimtool.chapter11.section12;

import xyz.vimtool.chapter14.section3.Pet;
import xyz.vimtool.chapter14.section3.Pets;

import java.util.*;

/**
 * Collection接口与容器迭代器比较
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class InterfaceVsIterator {

    public static void display(Iterator<Pet> iterator) {
        while (iterator.hasNext()) {
            Pet pet = iterator.next();
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet pet : pets) {
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<>();
        String[] names = "Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy".split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }

        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());

        System.out.println(petMap);
        System.out.println(petMap.keySet());

        display(petMap.values());
        display(petMap.values().iterator());
    }
}
