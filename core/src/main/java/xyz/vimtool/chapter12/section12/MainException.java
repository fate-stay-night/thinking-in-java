package xyz.vimtool.chapter12.section12;

import java.io.FileInputStream;

/**
 * 把异常传递给控制台
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class MainException {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("core/src/main/java/xyz/vimtool/chapter12/section12/MainException.java");
        inputStream.close();
    }
}
