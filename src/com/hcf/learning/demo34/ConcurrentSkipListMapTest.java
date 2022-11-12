package com.hcf.learning.demo34;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {
    public static void main(String[] args) throws InterruptedException {
        MyService5 myService5 = new MyService5();
        MyThread3 t1 = new MyThread3(myService5);
        MyThread3 t2 = new MyThread3(myService5);
        MyThread3 t3 = new MyThread3(myService5);
        MyThread3 t4 = new MyThread3(myService5);
        MyThread3 t5 = new MyThread3(myService5);

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t5.start();
    }
}

class UserInfo implements Comparable<UserInfo> {
    private int id;
    private String username;

    public UserInfo(int id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(UserInfo o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class MyService5 {
    public ConcurrentSkipListMap<UserInfo, String> map = new ConcurrentSkipListMap<>();

    public MyService5() {
        UserInfo userInfo1 = new UserInfo(1, "userInfo1");
        UserInfo userInfo3 = new UserInfo(3, "userInfo3");
        UserInfo userInfo5 = new UserInfo(5, "userInfo5");
        UserInfo userInfo2 = new UserInfo(2, "userInfo2");
        UserInfo userInfo4 = new UserInfo(4, "userInfo4");

        map.put(userInfo1, "userinfo1");
        map.put(userInfo3, "userinfo3");
        map.put(userInfo5, "userinfo5");
        map.put(userInfo2, "userinfo2");
        map.put(userInfo4, "userinfo4");
    }

    public void testMethod() {
        System.out.println("before map size() = " + map.size());
        Map.Entry<UserInfo, String> userInfoStringEntry = map.pollFirstEntry();
        System.out.println("after map size() = " + map.size());
        UserInfo userInfo = userInfoStringEntry.getKey();
        System.out.println(userInfo.getId() + " " + userInfo.getUsername() + " " + map.get(userInfo) + " " + userInfoStringEntry.getValue());
    }
}

class MyThread3 extends Thread {
    private MyService5 myService;

    public MyThread3(MyService5 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}