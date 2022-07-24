package com.hcf.learning.demo17;

public class InnerClassSyn2 {
    public static void main(String[] args) {
        final OutClass1.InnerClass1 innerClass1 = new OutClass1.InnerClass1();
        final OutClass1.InnerClass2 innerClass2 = new OutClass1.InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                innerClass1.method1(innerClass2);
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                innerClass1.method2();
            }
        }, "T2");
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                innerClass2.method1();
            }
        }, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class OutClass1 {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {
                System.out.println(threadName + " in InnerClass1's method1()");
                for (int i = 0; i < 5; i++) {
                    System.out.println("i= " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(threadName + " leave InnerClass1's method1()");
            }
        }

        public synchronized void method2() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " in InnerClass1's method2()");
            for (int j = 0; j < 10; j++) {
                System.out.println("j= " + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(threadName + " leave InnerClass1's method2()");
        }
    }

    static class InnerClass2 {
        public synchronized void method1() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " in InnerClass2's method1()");
            for (int k = 0; k < 10; k++) {
                System.out.println("i= " + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(threadName + " leave InnerClass2's method1()");
        }
    }
}
