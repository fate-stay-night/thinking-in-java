package xyz.vimtool.chapter9.section9;

/**
 * 接口与工厂
 * 工厂方法设计模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());

        serviceConsumer(new Implementation2Factory());
    }
}

interface Service {

    void method1();

    void method2();
}

interface ServiceFactory {

    Service getService();
}

class Implementation1 implements Service {

    Implementation1() {}

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
}

/**
 * 工厂类
 */
class Implementation1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {

    Implementation2() {}

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

/**
 * 工厂类
 */
class Implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation2();
    }
}