package xyz.vimtool.chapter18.section12;

import java.io.*;

/**
 * 序列化控制
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */

class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {

    Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects");
        out.writeObject(b1);
        out.writeObject(b2);
        out.close();

        //now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) in.readObject();

        //Throws an exception
//        System.out.println("Recovering b2:");
//        b2 = (Blip2) in.readObject();
    }
}


