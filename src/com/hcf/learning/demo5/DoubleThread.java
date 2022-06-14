package com.hcf.learning.demo5;


public class DoubleThread {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}
/*
    this.getName() will return the CountOperate.name
    it will always print "Thread-0" unless set up a name
 */
class CountOperate extends Thread{
    public CountOperate() {
        System.out.println("CountOperate--begin");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run() {
        System.out.println("run--begin");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("run--end");
    }
}