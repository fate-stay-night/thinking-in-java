package xyz.vimtool.chapter21.section2;

import java.util.concurrent.TimeUnit;

/**
 * 使用内部类将线程代码隐藏在类中
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/5/15
 */
public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}

class InnerThread1 {
    private int countDown = 5;

    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.print(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.print("interrupted");
            }
        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }
}

class InnerThread2 {
    private int countDown = 5;

    private Thread thread;

    public InnerThread2(String name) {
        thread = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.print(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.print("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };

        thread.start();
    }
}

class InnerRunnable1 {

    private int countDown = 5;

    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {

        Thread thread;

        Inner(String name) {
            thread = new Thread(this, name);
            thread.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.print(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.print("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return thread.getName() + ": " + countDown;
        }
    }
}

class InnerRunnable2 {

    private int countDown = 5;

    private Thread thread;

    public InnerRunnable2(String name) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.print(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.print("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return thread.getName() + ": " + countDown;
            }
        }, name);
        thread.start();
    }
}

class ThreadMethod {
    private int countDown = 5;

    private Thread thread;

    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (thread == null) {
            thread = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.print(this);
                            if (--countDown == 0) {
                                return;
                            }
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.print("sleep() interrupted");
                    }
                }

                @Override
                public String toString() {
                    return thread.getName() + ": " + countDown;
                }
            };
        }
    }
}