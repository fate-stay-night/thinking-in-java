package xyz.vimtool.chapter14.section1;

import java.util.Arrays;
import java.util.List;

/**
 * 形状
 * 多态提现
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-27
 */
public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}

abstract class Shape {

    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}