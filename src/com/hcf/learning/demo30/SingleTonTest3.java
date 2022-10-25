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
class MyObject{
    private static MyObject myObject;
    private MyObject(){

    }
    public static MyObject getInstance(){
        try{
            if (myObject != null){
            }else{
                Thread.sleep(3000);
                synchronized(MyObject.class){
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myObject;
    }
}

class ThreadC extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}