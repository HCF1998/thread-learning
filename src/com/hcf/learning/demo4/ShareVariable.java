package com.hcf.learning.demo4;

public class ShareVariable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
class MyThread extends Thread {
    private int count = 5;
    //public MyThread(String name) {
    //    super();
    //    this.setName(name);
    //}
    @Override
    public void run() {
        super.run();
        //while (count > 0) {
            count--;
            System.out.println(this.currentThread().getName() + ",count = "+count);
        //}
    }
}
