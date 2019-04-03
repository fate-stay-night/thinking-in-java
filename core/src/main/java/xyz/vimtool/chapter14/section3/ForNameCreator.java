package xyz.vimtool.chapter14.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于类名构建
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            Mutt.class.getName(),
            Pug.class.getName(),
            EgyptianMau.class.getName(),
            Manx.class.getName(),
            Cymric.class.getName(),
            Rat.class.getName(),
            Mouse.class.getName(),
            Hamster.class.getName()
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
