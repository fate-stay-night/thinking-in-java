package xyz.vimtool.chapter18.section12;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化对象类
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien alien = new Alien();
        out.writeObject(alien);
    }
}
