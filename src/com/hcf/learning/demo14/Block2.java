package com.hcf.learning.demo14;

public class Block2 {

    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);

            String privateGetData1 = "value 1 threadName = " + Thread.currentThread().getName();
            String privateGetData2 = "value 2 threadName = " + Thread.currentThread().getName();

            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
                System.out.println(getData1);
                System.out.println(getData2);
                System.out.println("end task");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils2 {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class MyThread3 extends Thread {
    private Block2 block;

    public MyThread3(Block2 block) {
        super();
        this.block = block;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils2.beginTime1 = System.currentTimeMillis();
        block.doLongTimeTask();
        CommonUtils2.endTime1 = System.currentTimeMillis();
    }
}

class MyThread4 extends Thread {
    private Block2 block;

    public MyThread4(Block2 block) {
        super();
        this.block = block;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils2.beginTime2 = System.currentTimeMillis();
        block.doLongTimeTask();
        CommonUtils2.endTime2 = System.currentTimeMillis();
    }
}

class Run3 {
    public static void main(String[] args) {
        Block2 block = new Block2();
        MyThread3 myThread3 = new MyThread3(block);
        myThread3.start();
        MyThread4 myThread4 = new MyThread4(block);
        myThread4.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils2.beginTime1;
        if (CommonUtils2.beginTime2 < CommonUtils2.beginTime1) {
            beginTime = com.hcf.learning.demo14.CommonUtils.beginTime2;
        }

        long endTime = CommonUtils2.endTime1;
        if (CommonUtils2.endTime2 > CommonUtils2.endTime1) {
            endTime = CommonUtils2.endTime2;
        }

        System.out.println("cost:" + (endTime - beginTime) / 1000);
    }
}
