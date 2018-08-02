package xyz.vimtool.chapter21.section8;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 车辆生产仿真
 * 汽车组装线，每辆车都分为多个阶段构建，从创建底盘开始，紧跟着是安装发动机、车厢、车轮
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/27
 */
public class CarBuilder {

    public static void main(String[] args) throws Exception {
        CarQueue chassisQueue = new CarQueue();
        CarQueue finishingQueue = new CarQueue();

        ExecutorService executor = Executors.newCachedThreadPool();
        RobotPool pool = new RobotPool();

        executor.execute(new EngineRobot(pool));
        executor.execute(new DriveTrainRobot(pool));
        executor.execute(new WheelRobot(pool));

        executor.execute(new Assembler(chassisQueue, finishingQueue, pool));
        executor.execute(new Reporter(finishingQueue));

        // start everything running by producing chassis
        executor.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        executor.shutdownNow();
    }
}

class Car {

    /**
     * 编号
     */
    private final int id;

    /**
     * 发动机
     */
    private boolean engine = false;

    /**
     * 驱动系统
     */
    private boolean driveTrain = false;

    /**
     * 车轮
     */
    private boolean wheels = false;

    public Car() {
        id = -1;
    }

    public Car(int id) {
        this.id = id;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    @Override
    public String toString() {
        return "Car " + id + " [" + " engine: " + engine + ", driveTrain: " + driveTrain + ", wheels: " + wheels + " ]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car> {

}

/**
 * 底盘
 */
class ChassisBuilder implements Runnable {

    private CarQueue carQueue;

    private int counter = 0;

    public ChassisBuilder(CarQueue cars) {
        this.carQueue = cars;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car car = new Car(counter++);
                System.out.println("ChassisBuilder created " + car);
                carQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

/**
 * 装配
 */
class Assembler implements Runnable {

    private CarQueue chassisQueue;

    private CarQueue finishQueue;

    private Car car;

    private CyclicBarrier barrier = new CyclicBarrier(4);

    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishQueue = finishQueue;
        this.robotPool = robotPool;
    }

    public Car car() {
        return car;
    }

    public CyclicBarrier barrier() {
        return barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await();

                finishQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting assembler via interrupted");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Assembler off");
    }
}

class Reporter implements Runnable {

    private CarQueue carQueue;

    public Reporter(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(carQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupted");
        }

        System.out.println("Reporter off");
    }
}

/**
 * 装配机器人
 */
abstract class Robot implements Runnable {

    private RobotPool pool;

    private boolean engage = false;

    protected Assembler assembler;

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    abstract protected void performService();

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;

        pool.release(this);
        while (engage == false) {
            wait();
        }
    }

    @Override
    public void run() {
        try {
            powerDown();
            while (!Thread.interrupted()) {
                performService();

                // 同步
                assembler.barrier().await();

                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this + " off");
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

class EngineRobot extends Robot {

    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot {

    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing driveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {

    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing wheels");
        assembler.car().addWheels();
    }
}

class RobotPool {

    private Set<Robot> pool = new HashSet<>();

    public synchronized void add(Robot robot) {
        pool.add(robot);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler assembler) throws InterruptedException {
        for (Robot robot : pool) {
            if (robot.getClass().equals(robotType)) {
                pool.remove(robot);
                robot.assignAssembler(assembler);
                robot.engage();
                return;
            }
        }

        wait();
        hire(robotType, assembler);
    }

    public synchronized void release(Robot robot) {
        this.add(robot);
    }
}