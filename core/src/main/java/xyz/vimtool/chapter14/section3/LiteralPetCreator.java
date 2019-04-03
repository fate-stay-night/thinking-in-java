package xyz.vimtool.chapter14.section3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用类字面常量
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public class LiteralPetCreator extends PetCreator {

    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> ALL_TYPES = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class,
            EgyptianMau.class, Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
    ));

    private static final List<Class<? extends Pet>> TYPES = ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class), ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}