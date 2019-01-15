package xyz.vimtool.chapter11.section12;

import xyz.vimtool.chapter14.section3.Pet;
import xyz.vimtool.chapter14.section3.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * 继承AbstractCollection及实现Iterator
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class CollectionSequence extends AbstractCollection<Pet> {

    private Pet[] pets = Pets.createArray(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence sequence = new CollectionSequence();
        InterfaceVsIterator.display(sequence);
        InterfaceVsIterator.display(sequence.iterator());
    }
}
