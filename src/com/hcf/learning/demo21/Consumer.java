package com.hcf.learning.demo21;

public class Consumer {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized(lock){
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get value: "+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerThread extends Thread {
    private Consumer consumer;

    public ConsumerThread(Consumer consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}
