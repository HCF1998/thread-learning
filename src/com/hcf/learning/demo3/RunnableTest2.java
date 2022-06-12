package com.hcf.learning.demo3;

public class RunnableTest2 {
    public static void main(String[] args) {
        BServer bServer = new BServer();
        Thread thread = new Thread(bServer);
        thread.start();
    }
}

class AServer{
    public void a_save_method() {
        System.out.println("a_save_method running");
    }
}

class BServer extends AServer implements Runnable{
    public void b_save_method() {
        System.out.println("b_save_method running");
    }
    @Override
    public void run() {
        b_save_method();
    }
}