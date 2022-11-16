package com.hcf.learning.demo35;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest4 {
    public static void main(String[] args) {
        try{
            MyServiceD myServiceD = new MyServiceD();

            MyThreadE myThreadE = new MyThreadE(myServiceD);
            myThreadE.setName("MyThreadE");
            myThreadE.start();
            Thread.sleep(4000);
            System.out.println("queue size: " + myServiceD.queue.size());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyServiceD{
    public TransferQueue queue = new LinkedTransferQueue();
}

class MyThreadE extends Thread{
    private MyServiceD myServiceD;
    public MyThreadE(MyServiceD myServiceD){
        super();
        this.myServiceD = myServiceD;

}
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" beginE "+System.currentTimeMillis());
        System.out.println("tryTransfer return value: "+myServiceD.queue.tryTransfer("data"));
        try {
            System.out.println("tryTransfer1 return value: "+myServiceD.queue.tryTransfer("data1",3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" endA "+System.currentTimeMillis());
    }
}

