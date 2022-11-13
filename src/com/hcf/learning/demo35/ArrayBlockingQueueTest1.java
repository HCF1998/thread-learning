package com.hcf.learning.demo35;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest1 {
    public static void main(String[] args) {
        try {
            ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
            queue.put("1");
            queue.put("2");
            queue.put("3");
            System.out.println(queue.size());
            System.out.println(System.currentTimeMillis());
            Object object = (Object) queue.take();
            System.out.println("objects: " + object);
            queue.put("4");
            System.out.println(System.currentTimeMillis());

            ArrayBlockingQueue queue2 = new ArrayBlockingQueue(3);
            System.out.println("begin "+System.currentTimeMillis());
            System.out.println(queue2.take());
            System.out.println("end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
