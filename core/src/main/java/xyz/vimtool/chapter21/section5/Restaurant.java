package xyz.vimtool.chapter21.section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者（单一的生产者消费者）
 * 利用餐厅里的厨师和服务员来模拟生产者和消费者关系
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/17
 */
public class Restaurant {

    Meal meal;

    ExecutorService executorService = Executors.newCachedThreadPool();

    WaitPerson waitPerson = new WaitPerson(this);

    Chef chef = new Chef(this);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

/**
 * 厨师生产的菜
 */
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

/**
 * 服务员
 */
class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        // 等待生产菜
                        wait();
                    }
                }

                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    // 唤醒厨师
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

/**
 * 厨师
 */
class Chef implements Runnable {

    private Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        // 等待服务员上菜
                        wait();
                    }
                }

                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.executorService.shutdownNow();
                }

                System.out.println("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    // 唤醒服务员
                    restaurant.waitPerson.notifyAll();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
