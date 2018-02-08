package xyz.vimtool.chapter18.section12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化持久性
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */

class House implements Serializable {

}

class Animal implements Serializable {

    private String name;

    private House preferredHouse;

    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return name + "[" + super.toString() + "], " + preferredHouse + "\n";
    }
}

public class MyWorld {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: " + animals);

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream out1 = new ObjectOutputStream(buf1);
        out1.writeObject(animals);
        out1.writeObject(animals); //write a 2nd set

        //write to a different stream
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(buf2);
        out2.writeObject(animals);

        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List animals1 = (List) in1.readObject();
        List animals2 = (List) in1.readObject();
        List animals3 = (List) in2.readObject();
        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);
        System.out.println("animals3: " + animals3);
    }
}
