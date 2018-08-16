package xyz.vimtool.chapter9.section8;

/**
 * 嵌套接口
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class NestingInterfaces {

    public class BImp implements A.B {

        @Override
        public void f() {}
    }

    class CImp implements A.C {

        @Override
        public void f() {}
    }
  // 错误
//    class DImp implements A.D {
//
//    }

    class EImp implements E {

        @Override
        public void g() {}
    }

    class EGImp implements E.G {

        @Override
        public void f() {}
    }

    class EImp2 implements E {

        @Override
        public void g() {}

        class EG implements E.G {

            @Override
            public void f() {}
        }
    }

    public static void main(String[] args) {
        A a = new A();

        A a1 = new A();
        a1.receiveD(a.getD());
    }
}

class A {

    interface B {

        void f();
    }

    public class BImp implements B {

        @Override
        public void f() {}
    }

    private class BImp2 implements B {

        @Override
        public void f() {}
    }

    public interface C {

        void f();
    }

    class CImp implements C {

        @Override
        public void f() {}
    }

    private class CImp2 implements C {

        @Override
        public void f() {}
    }

    private interface D {

        void f();
    }

    private class DImp implements D {

        @Override
        public void f() {}
    }

    public class DImp2 implements D {

        @Override
        public void f() {}
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {

    interface G {

        void f();
    }

    public interface H {

        void f();
    }

    void g();
}