package com.hcf.learning.demo30;

public class SingleTonTest3 {
    public static void main(String[] args) {
        ThreadC thread1 = new ThreadC();
        ThreadC thread2 = new ThreadC();
        ThreadC thread3 = new ThreadC();

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
class MyObject3 {
    private static MyObject3 myObject3;
    private MyObject3(){

    }
    public static MyObject3 getInstance(){
        try{
            if (myObject3 != null){
            }else{
                Thread.sleep(3000);
                synchronized(MyObject3.class){
                    myObject3 = new MyObject3();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myObject3;
    }
}

class ThreadC extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject3.getInstance().hashCode());
    }
}