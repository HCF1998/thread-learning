package com.hcf.learning.demo21;

public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        ProducerThread producerThread = new ProducerThread(producer);
        ConsumerThread consumerThread = new ConsumerThread((consumer));

        producerThread.start();
        consumerThread.start();
    }
}
