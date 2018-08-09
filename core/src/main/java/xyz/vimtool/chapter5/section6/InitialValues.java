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
public class InitialValues {

    boolean t;

    char c;

    byte b;

    short s;

    int i;

    long l;

    float f;

    double d;

    InitialValues reference;

    void printInitialValues() {
        System.out.println("Data type      Initial value");
        System.out.println("boolean        " + t);
        System.out.println("char           [" + c + "]");
        System.out.println("byte           " + b);
        System.out.println("short          " + s);
        System.out.println("int            " + i);
        System.out.println("long           " + l);
        System.out.println("float          " + f);
        System.out.println("double         " + d);
        System.out.println("reference      " + reference);
    }

    public static void main(String[] args) {
        InitialValues initialValues = new InitialValues();
        initialValues.printInitialValues();
    }
}
