package xyz.vimtool.chapter21.section7;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * 定时任务，温室控制系统
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/7/26
 */
public class GreenhouseScheduler {

    private volatile boolean light = false;

    private volatile boolean water = false;

    private String thermostat = "Day";

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;

    private int tempDirection = +1;

    private float lastHumidity = 50.0f;

    private int humidityDirection = +1;

    private Random random = new Random(47);

    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    /**
     * 定时任务
     *
     * @param event 任务
     * @param delay 执行时间延迟
     */
    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    /**
     * 定时周期任务
     *
     * @param event        任务
     * @param initialDelay 初始执行时间延迟
     * @param period       时间间隔周期
     */
    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        GreenhouseScheduler greenhouse = new GreenhouseScheduler();
        greenhouse.schedule(greenhouse.new Terminate(), 5000);
        greenhouse.repeat(greenhouse.new Bell(), 0, 1000);
        greenhouse.repeat(greenhouse.new ThermostatNight(), 0, 2000);
        greenhouse.repeat(greenhouse.new LightOn(), 0, 200);
        greenhouse.repeat(greenhouse.new LightOff(), 0, 400);
        greenhouse.repeat(greenhouse.new WaterOn(), 0, 600);
        greenhouse.repeat(greenhouse.new WaterOff(), 0, 800);
        greenhouse.repeat(greenhouse.new ThermostatDay(), 0, 1400);
        greenhouse.repeat(greenhouse.new CollectData(), 500, 500);
    }

    class LightOn implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    /**
     * 夜晚恒温
     * thermostat 恒温器
     */
    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    /**
     * 白天恒温
     * thermostat 恒温器
     */
    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    /**
     * 通知/警报
     */
    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();

            ExecutorService singleThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
            singleThreadExecutor.execute(() -> {
                for (DataPoint dataPoint : data) {
                    System.out.println(dataPoint);
                }
            });
            singleThreadExecutor.shutdown();
        }
    }

    static class DataPoint {
        /**
         * 时间
         */
        final Calendar time;

        /**
         * 温度
         */
        final float temperature;

        /**
         * 湿度
         */
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(time.getTime())
                    + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    class CollectData implements Runnable {
        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);

                if (random.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + random.nextFloat());

                if (random.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * random.nextFloat();

                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }
}
