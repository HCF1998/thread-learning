package com.hcf.learning.demo23;

public class WaitNotifyInsertTest {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackUpB backUpB = new BackUpB(dbTools);
            backUpB.start();
            BackUpA backUpA = new BackUpA(dbTools);
            backUpA.start();
        }
    }
}

class DBTools{
    volatile private boolean preIsA = false;
    synchronized public void backupA(){
        try{
            while(preIsA == true){
                wait();
            }
            for(int i = 0 ;i<5;i++){
                System.out.println("-----");
            }
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void backupB(){
        try{
            while(preIsA == false){
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("+++++");
            }
            preIsA = false;
            notifyAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BackUpA extends Thread{
    private DBTools dbTools;

    public BackUpA(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}

class BackUpB extends Thread{
    private DBTools dbTools;

    public BackUpB(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
