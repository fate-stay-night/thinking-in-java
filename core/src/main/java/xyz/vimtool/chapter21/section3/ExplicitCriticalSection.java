package xyz.vimtool.chapter21.section3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示的Lock对象来创建临界区
 *
 * ExplicitPairManager2()方法线程出错的看法：
 * ExplicitPairManager1，PairManager1，PairManager2中的increment()方法都被synchronized关键字标记；
 * 在本例中，无论是同步方法还是同步控制块，锁的都是PairManager的对象；
 * 由synchronized概念可知：要控制对共享资源的访问，得先把它包装进一个对象。然后把所有要访问这个资源的方法标记为synchronized。如果某个任务处于一个对标记为synchronized的方法的调用中，那么这个线程从该方法返回之前，其他所有要调用类中任何标记为synchronized的方法的线程都会被阻塞。
 * 所以线程在进行ExplicitPairManager2中的increment()方法时，并不会影响PairManager中的另一个synchronized方法getPair()获得锁，因此，getPair().checkState()方法可能读取到共享资源p.x和p.y非同步状态的值。
 *
 * 如果多个方法操作同一资源，请给所有方法加锁，并且要是同一个锁。
 * 此例中，主要问题就是Lock和Synchronized不是同一个锁，对共享资源的访问并不互斥。
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/6/1
 */
public class ExplicitCriticalSection {

    public static void main(String[] args) {
        CriticalSection.testApproaches(new ExplicitPairManager1(), new ExplicitPairManager2());
    }
}

// Synchronized the entire method
class ExplicitPairManager1 extends PairManager {

    private Lock lock =new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            store(super.getPair());
        } finally {
            lock.unlock();
        }
    }
}

// Use a critical section
class ExplicitPairManager2 extends PairManager {

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            // 这里造成错误，非同一个锁
            temp = super.getPair();
            store(temp);
        } finally {
            lock.unlock();
        }
    }
}
