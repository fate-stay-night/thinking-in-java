package xyz.vimtool.chapter12.section8;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-20
 */
public class WithFinally {

    private static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
