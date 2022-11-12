package com.hcf.learning.demo34;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest3 {
    public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        System.out.println(queue.poll());
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.element());
    }
}
