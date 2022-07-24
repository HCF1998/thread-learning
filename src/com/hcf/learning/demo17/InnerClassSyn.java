package com.hcf.learning.demo17;

public class InnerClassSyn {
    public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        }, "A");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        }, "B");

        t1.start();
        t2.start();
    }
}

class OutClass {
    static class Inner {
        public void method1() {
            synchronized ("other lock") {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i= " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2() {
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + " i= " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
