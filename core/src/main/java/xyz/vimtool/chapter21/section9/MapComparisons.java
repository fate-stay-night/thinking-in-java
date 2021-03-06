package xyz.vimtool.chapter21.section9;

import xyz.vimtool.chapter16.section6.CountingGenerator;
import xyz.vimtool.chapter17.section2.MapData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 比较各种Map实现
 * synchronizedHashMap和ConcurrentHashMap在性能方面的比较
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/1
 */
public class MapComparisons {

    public static void main(String[] args) {
        Tester.initMain(args);

        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);

        new ConcurrentHashMapTest(10, 0);
        new ConcurrentHashMapTest(9, 1);
        new ConcurrentHashMapTest(5, 5);
        Tester.executor.shutdown();
    }
}

abstract class MapTest extends Tester<Map<Integer, Integer>> {

    MapTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            executor.execute(new Reader());
        }

        for (int i = 0; i < nWriters; i++) {
            executor.execute(new Writer());
        }
    }

    class Reader extends TestTask {

        long result = 0;

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    result += testContainer.get(index);
                }
            }
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask {

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                     testContainer.put(index, writeData[index]);
                }
            }
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }
}

class SynchronizedHashMapTest extends MapTest {

    SynchronizedHashMapTest(int nReaders, int nWriters) {
        super("SynchronizedHashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(new HashMap<>(MapData.map(
                new CountingGenerator.Integer(), new CountingGenerator.Integer(), containerSize)));
    }
}

class ConcurrentHashMapTest extends MapTest {

    ConcurrentHashMapTest(int nReaders, int nWriters) {
        super("ConcurrentHashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<>(MapData.map(new CountingGenerator.Integer(),
                new CountingGenerator.Integer(), containerSize));
    }
}