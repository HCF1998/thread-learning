package com.hcf.learning.demo25;

public class ThreadLocal_Inheritable {
    public static void main(String[] args) {
        try{
            for(int i = 0;i<10;i++){
                if(Tools1.t1.get()==null){
                    Tools1.t1.set("main thread set value");
                }
                System.out.println("main thread get value : "+Tools1.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tools1{
    public static InheritableThreadLocal t1 = new InheritableThreadLocal();
}

class ThreadA extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadA: "+ Tools1.t1.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}