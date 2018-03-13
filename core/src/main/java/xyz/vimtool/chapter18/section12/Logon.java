package xyz.vimtool.chapter18.section12;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 序列化瞬时处理
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class Logon implements Serializable {

    private Date date = new Date();

    private String username;

    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "logon info: \n username: " + username + "\n date: " + date + "\n password: " + password;
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        out.writeObject(a);
        out.close();

        TimeUnit.SECONDS.sleep(1);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        a = (Logon) in.readObject();
        in.close();
        System.out.println("logon a = " + a);
    }
}
