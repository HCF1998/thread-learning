package com.hcf.learning.demo35;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest5 {
    public static void main(String[] args) throws InterruptedException {
        MyServiceE myServiceE = new MyServiceE();
        for (int i = 0; i <10;i++){
            MyThreadF   myThreadF = new MyThreadF(myServiceE);
            myThreadF.setName("f");
            myThreadF.start();
        }
        Thread.sleep(1000);
        System.out.println("is there any threads are waiting to get the value: "+myServiceE.queue.hasWaitingConsumer());
        System.out.println("the number of waiting threads: "+myServiceE.queue.getWaitingConsumerCount());
    }
}

class MyServiceE{
    public TransferQueue queue = new LinkedTransferQueue();
}

class MyThreadF extends Thread{
    private MyServiceE myService;
    public MyThreadF(MyServiceE myService){
        super();
        this.myService = myService;

}
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" get value = "+myService.queue.take());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}