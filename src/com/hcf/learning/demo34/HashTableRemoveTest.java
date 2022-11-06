package com.hcf.learning.demo34;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableRemoveTest {
    public static void main(String[] args) {
        MyService2 myService2 = new MyService2();
        Thread2A thread2A = new Thread2A(myService2);
        Thread2A thread2B = new Thread2A(myService2);
        thread2A.start();
        thread2B.start();
    }
}
class MyService2{
    public Hashtable table = new Hashtable();
    public MyService2() {
        for (int i = 0; i < 2000; i++) {
            table.put(Thread.currentThread().getName()+i+1,"abc");
        }
    }

    public void testMethod(){
        Iterator iterator = table.keySet().iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            iterator.remove();
            System.out.println(table.size()+" "+Thread.currentThread().getName());
        }
    }
}
class Thread2A extends Thread{
    private MyService2 myService2;

    public Thread2A(MyService2 myService2) {
        super();
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.testMethod();
    }
}