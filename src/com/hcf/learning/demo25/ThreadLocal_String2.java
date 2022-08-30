package com.hcf.learning.demo25;

public class ThreadLocal_String2 {
    public static void main(String[] args) throws InterruptedException {
        if (Tools3.t1.get()==null){
            Tools3.t1.set("set by main");
        }
        System.out.println(" get by main "+Tools3.t1.get());
        Thread.sleep(100);
        ThreadD threadD = new ThreadD();
        threadD.start();
        Thread.sleep(3000);
        for (int i = 0; i < 10; i++) {
            System.out.println("main end get value "+Tools3.t1.get());
            Thread.sleep(1000);
        }
    }
}

class Tools3{
    public static InheritableThreadLocal t1 = new InheritableThreadLocal();
}
class ThreadD extends Thread{
    @Override
    public void run() {
        try{
            for(int i = 0; i < 10; i++){
                System.out.println("get by ThreadD "+Tools3.t1.get());
                Thread.sleep(1000);
                if(i==5){
                    Tools3.t1.set("new set by ThreadD ");
                    System.out.println("ThreadD has new value");
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
