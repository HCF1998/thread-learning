package com.hcf.learning.demo18;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();

        Thread thread = new Thread(countService);
        thread.start();
        Thread thread1 = new Thread(countService);
        thread1.start();
        Thread thread2 = new Thread(countService);
        thread2.start();
        Thread thread3 = new Thread(countService);
        thread3.start();
        Thread thread4 = new Thread(countService);
        thread4.start();

    }
}

class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
        System.out.println("end");
    }
}
