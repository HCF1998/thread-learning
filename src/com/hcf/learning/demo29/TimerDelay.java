package com.hcf.learning.demo29;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDelay {
    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("run time = "+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        System.out.println("now time = "+System.currentTimeMillis());
        timer.schedule(myTask,5000);
    }
}
