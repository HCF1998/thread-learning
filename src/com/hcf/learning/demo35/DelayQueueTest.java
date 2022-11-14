package com.hcf.learning.demo35;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        UserInfo1 userInfo5 = new UserInfo1("userInfo5",5);
        UserInfo1 userInfo4 = new UserInfo1("userInfo4",4);
        UserInfo1 userInfo3 = new UserInfo1("userInfo3",3);
        UserInfo1 userInfo2 = new UserInfo1("userInfo2",2);
        UserInfo1 userInfo1 = new UserInfo1("userInfo1",1);

        DelayQueue<UserInfo1> delayQueue = new DelayQueue<>();
        delayQueue.add(userInfo5);
        delayQueue.add(userInfo4);
        delayQueue.add(userInfo3);
        delayQueue.add(userInfo2);
        delayQueue.add(userInfo1);

        System.out.println(delayQueue.take().getName()+" "+System.currentTimeMillis());
        System.out.println(delayQueue.take().getName()+" "+System.currentTimeMillis());
        System.out.println(delayQueue.take().getName()+" "+System.currentTimeMillis());
        System.out.println(delayQueue.take().getName()+" "+System.currentTimeMillis());
        System.out.println(delayQueue.take().getName()+" "+System.currentTimeMillis());

    }
}

class UserInfo1 implements Delayed {
    private String name;
    private long runNanoTime;

    public UserInfo1(String name, long secondTime) {
        this.name = name;
        long dalayNanoTime = TimeUnit.SECONDS.toNanos(secondTime);
        runNanoTime = System.nanoTime() + dalayNanoTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Delayed o) {
        UserInfo1 other = (UserInfo1) o;
        if (this.runNanoTime > other.runNanoTime) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return runNanoTime - System.nanoTime();
    }

}
