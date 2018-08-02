package xyz.vimtool.chapter17.section2;

import xyz.vimtool.chapter15.section3.Generator;

import java.util.LinkedHashMap;

/**
 * Map生成器
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/1
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    public MapData(Generator<Pair<K, V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }

    public MapData(Generator<K> generatorKey, Generator<V> generatorValue, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generatorKey.next(), generatorValue.next());
        }
    }

    public MapData(Generator<K> generatorKey, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generatorKey.next(), value);
        }
    }

    public MapData(Iterable<K> generatorKey, Generator<V> generatorValue) {
        for (K key : generatorKey) {
            put(key, generatorValue.next());
        }
    }

    public MapData(Iterable<K> generatorKey, V value) {
        for (K key : generatorKey) {
            put(key, value);
        }
    }

    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> generator, int quantity) {
        return new MapData<>(generator, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> generatorKey, Generator<V> generatorValue, int quantity) {
        return new MapData<>(generatorKey, generatorValue, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> generatorKey, V value, int quantity) {
        return new MapData<>(generatorKey, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> generatorKey, Generator<V> generatorValue) {
        return new MapData<>(generatorKey, generatorValue);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> generatorKey, V value) {
        return new MapData<>(generatorKey, value);
    }
}
