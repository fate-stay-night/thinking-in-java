package xyz.vimtool.chapter17.section2;

/**
 * 键值对
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/1
 */
public class Pair<K, V> {

    public final K key;

    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
