package xyz.vimtool.chapter21.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 临界区
 * 同步控制块与同步控制方法的比较，
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/31
 */
public class CriticalSection {

    // Test the two different approaches
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        PairManipulator pm1 = new PairManipulator(pman1);
        PairManipulator pm2 = new PairManipulator(pman2);

        PairChecker pcheck1 = new PairChecker(pman1);
        PairChecker pcheck2 = new PairChecker(pman2);

        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(pcheck1);
        executorService.execute(pcheck2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        testApproaches(new PairManger1(), new PairManager2());
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

// 该类使用了设计模式：模板方法（在该类的结构中，它的一些功能在基类中实现，并且其一个或多个抽象方法在派生类中定义）
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger();

    protected Pair pair = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        // make a copy to keep the original safe
        return new Pair(pair.getX(), pair.getY());
    }

    protected void store(Pair pair) {
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50L);
        } catch (InterruptedException ignore) {}
    }

    public abstract void increment();
}

// Synchronized the entire method
class PairManger1 extends PairManager {

    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        super.store(super.getPair());
    }
}

// Use a critical section8
class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp;

        synchronized (this) {
            pair.incrementX();
            pair.incrementY();
            temp = super.getPair();
        }
        super.store(temp);
    }
}

class PairManipulator implements Runnable {

    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {

    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}