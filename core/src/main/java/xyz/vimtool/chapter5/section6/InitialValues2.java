package xyz.vimtool.chapter5.section6;

/**
 * 类成员初始化
 * 类的数据成员是基本类型时，会有默认值
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class InitialValues2 {

    boolean t = true;

    char c = 'x';

    byte b = 47;

    short s = 0xff;

    int i = 999;

    long l = 1;

    float f = 2.14f;

    double d = 2.14159;

    void printInitialValues2() {
        System.out.println("Data type      Initial value");
        System.out.println("boolean        " + t);
        System.out.println("char           [" + c + "]");
        System.out.println("byte           " + b);
        System.out.println("short          " + s);
        System.out.println("int            " + i);
        System.out.println("long           " + l);
        System.out.println("float          " + f);
        System.out.println("double         " + d);
    }

    public static void main(String[] args) {
        InitialValues2 initialValues = new InitialValues2();
        initialValues.printInitialValues2();
    }
}
