package xyz.vimtool.chapter19.section10;

import java.util.EnumSet;

/**
 * 常量相关的方法关联到选择中
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-27
 */
public class CarWash {

    public enum Cycle {

        UNDERBODY {
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },

        WHEELWASH {
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },

        PREWASH {
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },

        BASIC {
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },

        HOTWAX {
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },

        RINSE {
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },

        BLOWDRY {
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle c: cycles) {
            c.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();

        //Order of addition is unimportant
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }
}
