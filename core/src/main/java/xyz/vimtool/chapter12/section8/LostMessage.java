package xyz.vimtool.chapter12.section8;

/**
 * 异常丢失
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                lostMessage.f();
            } finally {
                lostMessage.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class VeryImportantException extends Exception {

    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {

    @Override
    public String toString() {
        return "A trivial exception";
    }
}