package xyz.vimtool.chapter12.section11;

/**
 * 异常匹配示例
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class Human {

    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}

class Annoyance extends Exception {}

class Sneeze extends Annoyance {}