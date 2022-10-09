package com.hcf.learning.demo29;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
        long nowTime = System.currentTimeMillis();
        System.out.println("now time = "+nowTime);
        long scheduleTime = nowTime + 5000;
        System.out.println("schedule time = "+scheduleTime);

        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        Thread.sleep(2000);
        timer.schedule(myTask,new Date(scheduleTime));
        Thread.sleep(5000);
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("task start: "+System.currentTimeMillis());
    }
}
