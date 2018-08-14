package xyz.vimtool.chapter18.section12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 序列化持久性
 *
 * @author zhangzheng
 * @version 1.0
 * @date 2018-2-8
 * @since jdk1.8
 */

abstract class Shape implements Serializable {

    public static final int RED = 1, BLUE = 2, GREEN = 3;

    private int xPos, yPos, dimension;

    private static Random rand = new Random(47);

    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xPos = rand.nextInt(100);
        int yPos = rand.nextInt(100);
        int dimension = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xPos, yPos, dimension);
            case 1:
                return new Square(xPos, yPos, dimension);
            case 2:
                return new Line(xPos, yPos, dimension);
        }
    }
}

class Circle extends Shape {

    private static int color = RED;

    public Circle(int xPos, int yPos, int dim) {
        super(xPos, yPos, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Square extends Shape {

    private static int color;

    public Square(int xPos, int yPos, int dim) {
        super(xPos, yPos, dim);
        color = RED;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Line extends Shape {

    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream out) throws IOException {
        out.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream in) throws IOException {
        color = in.readInt();
    }

    public Line(int xPos, int yPos, int dim) {
        super(xPos, yPos, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

public class CADState {

    public static void storeCADState() throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();

        //add references to the class objects
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();

        //make some shapes
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        //set all the static colors to GREEN
        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }

        //save the state vector
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        //Display the shapes
        System.out.println(shapes);
    }

    @SuppressWarnings("unchecked")
    public static void recoverCADState() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));

        //Read in the same order they were written
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }

    public static void main(String[] args) throws Exception {
//        storeCADState();
        recoverCADState();
    }
}
