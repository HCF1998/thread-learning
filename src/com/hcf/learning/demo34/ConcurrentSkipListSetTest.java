package com.hcf.learning.demo34;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {
    public static void main(String[] args) throws InterruptedException {
        MyService6 myService6 = new MyService6();
        MyThread4 myThread1 = new MyThread4(myService6);
        MyThread4 myThread2 = new MyThread4(myService6);
        MyThread4 myThread3 = new MyThread4(myService6);
        MyThread4 myThread4 = new MyThread4(myService6);
        MyThread4 myThread5 = new MyThread4(myService6);

        myThread1.start();
        Thread.sleep(1000);
        myThread2.start();
        Thread.sleep(1000);
        myThread3.start();
        Thread.sleep(1000);
        myThread4.start();
        Thread.sleep(1000);
        myThread5.start();
    }
}
class MyThread4 extends Thread {
    private MyService6 myService;
    public MyThread4(MyService6 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        UserInfo1 userInfo1 = (UserInfo1) myService.set.pollFirst();
        System.out.println(userInfo1.getId()+" "+userInfo1.getUsername());
    }
}

class MyService6{
    public ConcurrentSkipListSet set = new ConcurrentSkipListSet();

    public MyService6(){
        UserInfo1 userInfo1 = new UserInfo1(1,"username1");
        UserInfo1 userInfo2 = new UserInfo1(2,"username2");
        UserInfo1 userInfo3 = new UserInfo1(3,"username3");
        UserInfo1 userInfo41 = new UserInfo1(4,"username41");
        UserInfo1 userInfo42= new UserInfo1(4,"username42");
        UserInfo1 userInfo5 = new UserInfo1(5,"username5");
        set.add(userInfo1);
        set.add(userInfo2);
        set.add(userInfo3);
        set.add(userInfo41);
        set.add(userInfo42);
        set.add(userInfo5);
    }
}
class UserInfo1 implements  Comparable<UserInfo1>{
    private int id;
    private String username;

    public UserInfo1(int id, String username) {
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
    public int compareTo(UserInfo1 o) {
        if (this.id <o.getId()){
            return -1;
        }
        if (this.id > o.getId()){
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((username == null)? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserInfo1 other = (UserInfo1) obj;
        if (id != other.id) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }
}