package com.hcf.learning.demo29;

import java.util.Date;
import java.util.Timer;

public class TimerTest3 {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println("now time = "+nowTime);

        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask,new Date(nowTime-5000));
    }
}
