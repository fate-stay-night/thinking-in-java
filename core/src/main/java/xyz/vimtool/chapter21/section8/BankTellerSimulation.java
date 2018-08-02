package xyz.vimtool.chapter21.section8;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 银行出纳员仿真
 * 本仿真中，每个顾客都要求出纳员给予其一定数量的服务时间，
 * 每个顾客获得的服务时间的数量都是不同的，并且都是随机的；
 * 每个顾客到达银行的时间都是随机的
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/26
 */
public class BankTellerSimulation {

    static final int MAX_LINE_SIZE = 50;

    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);

        executor.execute(new CustomerGenerator(customers));
        executor.execute(new TellerManager(executor, customers, ADJUSTMENT_PERIOD));

        System.out.println("Press Enter to quit");
        System.in.read();
        executor.shutdownNow();
    }
}

/**
 * 顾客
 */
class Customer {

    private final int serviceTime;

    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

/**
 * 顾客队列
 */
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }

        StringBuilder result = new StringBuilder();
        this.forEach(customer -> result.append(customer));
        return result.toString();
    }
}

/**
 * 顾客生成器
 */
class CustomerGenerator implements Runnable {

    private CustomerLine customers;

    private static Random random = new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                customers.put(new Customer(random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

/**
 * 出纳员
 */
class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;

    private final int id = counter++;

    /**
     * 服务过顾客数量
     */
    private int customersServed = 0;

    private CustomerLine customers;

    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());

                synchronized (this) {
                    customersServed++;
                    while (!servingCustomerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " terminating");
        }
    }

    public synchronized void doSomethingElse() {
        customersServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine: "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public synchronized int compareTo(Teller o) {
         return customersServed < o.customersServed ? -1 : (customersServed == o.customersServed ? 0 : 1);
    }

    public String shortString() {
        return "T " + id;
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }
}

/**
 * 出纳员管理
 */
class TellerManager implements Runnable {

    private ExecutorService executor;

    private CustomerLine customers;

    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();

    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();

    private int adjustmentPeriod;

    private static Random random = new Random(47);

    public TellerManager(ExecutorService executor, CustomerLine customers, int adjustmentPeriod) {
        this.executor = executor;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;

        Teller teller = new Teller(customers);
        executor.execute(teller);
        workingTellers.add(teller);
    }

    /**
     * 分配一个出纳员
     */
    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    public void adjustTellerNumber() {
        if (customers.size() / workingTellers.size() > 2) {
            if (tellersDoingOtherThings.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }

            // 或者创建一个出纳员
            Teller teller = new Teller(customers);
            executor.execute(teller);
            workingTellers.add(teller);
            return;
        }

        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }

        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.toSeconds(adjustmentPeriod);
                adjustTellerNumber();

                System.out.println(customers + " { ");
                for (Teller teller: workingTellers) {
                    System.out.println(teller.shortString() + "");
                }
                System.out.println(" } ");
            }
        } catch (Exception e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}