package com.hcf.learning.demo29;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerLater {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println("now time " + nowTime);

        long scheduleTime1 = nowTime;
        long scheduleTime2 = nowTime + 5000;
        System.out.println("scheduleTime1 = " + scheduleTime1);
        System.out.println("scheduleTime2 = " + scheduleTime2);

        MyTaskA myTaskA = new MyTaskA();
        MyTaskB myTaskB = new MyTaskB();

        Timer timer = new Timer();
        timer.schedule(myTaskA,new Date(scheduleTime1));
        timer.schedule(myTaskB,new Date(scheduleTime2));
    }
}

class MyTaskA extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("A begin timer = " + System.currentTimeMillis());
            Thread.sleep(10000);
            System.out.println("A end timer = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B begin timer = " + System.currentTimeMillis());
        System.out.println("B end timer = " + System.currentTimeMillis());
    }
}