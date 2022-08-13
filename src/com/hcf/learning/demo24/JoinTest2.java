package com.hcf.learning.demo24;

public class JoinTest2 {
    static int number1 = 0;
    static int number2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number1 = 1000;
            }

            ;
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number2 = 2000;
            }
        };

        long beginTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        System.out.println("A "+System.currentTimeMillis());
        t1.join();
        System.out.println("B "+System.currentTimeMillis());
        t2.join();
        System.out.println("C "+System.currentTimeMillis());
        long endTime = System.currentTimeMillis();
        System.out.println("number1: " + number1 + " number2: " + number2 + " time: " + (endTime - beginTime));
    }

}
