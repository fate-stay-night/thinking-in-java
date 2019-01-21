package xyz.vimtool.chapter12.section8;

/**
 * 异常丢失
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class ExceptionSilencer {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
