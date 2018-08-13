package xyz.vimtool.chapter7.section4;

/**
 * 确保正确清理类对象
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/13
 */
public class CADSystem extends Shape {

    private Circle circle;

    private Triangle triangle;

    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        circle = new Circle(1);
        triangle = new Triangle(1);
        System.out.println("Combined constructor");
    }

    @Override
    public void dispose() {
        System.out.println("CADSystem.dispose()");

        triangle.dispose();
        circle.dispose();

        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);

        try {

        } finally {
            x.dispose();
        }
    }
}

class Shape {

    Shape(int i) {
        System.out.println("Shape constructor");
    }

    void dispose() {
        System.out.println("Shape dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        System.out.println("Drawing circle");
    }

    @Override
    void dispose() {
        System.out.println("Erasing circle");
        super.dispose();
    }
}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        System.out.println("Drawing triangle");
    }

    @Override
    void dispose() {
        System.out.println("Erasing triangle");
        super.dispose();
    }
}

class Line extends Shape {

    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing line : " + start + ", " + end);
    }
}