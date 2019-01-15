package xyz.vimtool.chapter14.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-29
 */
public abstract class PetCreator {

    private Random random = new Random(47);

    /**
     * 获取类型列表
     *
     * @return 类型列表
     */
    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
