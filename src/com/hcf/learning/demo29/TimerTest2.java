package com.hcf.learning.demo29;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {
    public static void main(String[] args) throws InterruptedException {
        long nowTime = System.currentTimeMillis();
        System.out.println("now: " + nowTime);

        long scheduleTime = nowTime + 5000;
        System.out.println("schedule: " + scheduleTime);

        MyTask myTask = new MyTask();

        Timer timer = new Timer();

        timer.schedule(myTask, new Date(scheduleTime));

        Thread.sleep(5000);
        timer.cancel();
        Thread.sleep(2000);
    }
}