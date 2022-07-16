package com.hcf.learning.demo14;

public class Block {
    private String getData1;
    private String getData2;

    synchronized public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "value 1 threadName = " + Thread.currentThread().getName();
            getData2 = "value 2 threadName = " + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class MyThread1 extends Thread {
    private Block block;

    public MyThread1(Block block) {
        super();
        this.block = block;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        block.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

class MyThread2 extends Thread {
    private Block block;

    public MyThread2(Block block) {
        super();
        this.block = block;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        block.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}

class Run {
    public static void main(String[] args) {
        Block block = new Block();
        MyThread1 myThread1 = new MyThread1(block);
        myThread1.start();
        MyThread2 myThread2 = new MyThread2(block);
        myThread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("cost:" + (endTime - beginTime) / 1000);
    }
}