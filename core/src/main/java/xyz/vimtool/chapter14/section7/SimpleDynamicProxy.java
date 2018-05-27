package xyz.vimtool.chapter14.section7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/27
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bobobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        // 创建动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(realObject));
        consumer(proxy); // 代理调用
    }
}

/**
 * 动态代理调用控制类
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        System.out.println("***** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);

        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}
