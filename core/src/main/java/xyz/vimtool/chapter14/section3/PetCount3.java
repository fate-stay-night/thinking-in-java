package xyz.vimtool.chapter14.section3;

import xyz.vimtool.chapter17.section2.MapData;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

        public PetCounter() {
            super(MapData.map(LiteralPetCreator.ALL_TYPES, 0));
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends  Pet>, Integer> entry : entrySet()) {
                if (entry.getKey().isInstance(pet)) {
                    // 动态统计计数
                    put(entry.getKey(), entry.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                result.append(entry.getKey().getSimpleName());
                result.append("=");
                result.append(entry.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter counter = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }

        System.out.println();
        System.out.println(counter);
    }
}
