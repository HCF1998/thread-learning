package com.hcf.learning.demo12;

public class PublicVar {
    public String username = "A";
    public String password = "AAA";
    synchronized public void setValue(String userName, String passWord) {
        try {
            this.username = userName;
            Thread.sleep(5000);
            this.password = passWord;

            System.out.println("setValue method thread name = " + Thread.currentThread().getName() +
                    "username = " + username + " password = " + password);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // synchronized
    public void getValue() {
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() +
                " username=" + username + " password=" + password);
    }
}
class ThreadJ extends Thread {
    private PublicVar publicVar;

    public ThreadJ(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }
    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
class Run4{
    public static void main(String[] args) {
        try{
            PublicVar publicVar = new PublicVar();
            ThreadJ threadJ = new ThreadJ(publicVar);
            threadJ.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}