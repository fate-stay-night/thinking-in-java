package xyz.vimtool.chapter14.section3;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
