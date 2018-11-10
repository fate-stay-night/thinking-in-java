package xyz.vimtool.chapter10.section8;

/**
 * 温室系统控制
 * 命令设计模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018/11/10
 */
public class GreenHouseController {

    public static void main(String[] args) {
        GreenHouseControls controls = new GreenHouseControls();

        controls.addEvent(controls.new Bell(900));

        Event[] events = {
                controls.new ThermostatNight(0),
                controls.new LightOn(200),
                controls.new LightOff(400),
                controls.new WaterOn(600),
                controls.new WaterOff(800),
                controls.new ThermostatDay(1400),
        };

        controls.addEvent(controls.new Restart(2000, events));

        if (args.length == 1) {
            controls.addEvent(new GreenHouseControls.Terminate(new Integer(args[0])));
        }

        controls.run();
    }
}
