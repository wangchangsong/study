package com.wcs.study.demo.demo;

/**
 * TODO 类描述
 *
 * @author pro
 */
public class ThreadLocalDemo {

    private static A a = new A();
    private static final ThreadLocal<A> threadLocal = ThreadLocal.withInitial(() -> a);

    public static void main(String[] args) {
        Thread[] threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(() -> {
                threadLocal.get().setNumber(threadLocal.get().getNumber() + 1);
                System.out.println(Thread.currentThread().getName() + ":"
                        + threadLocal.get().getNumber());
            }, "Thread" + i);
        }


        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class A {

    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
