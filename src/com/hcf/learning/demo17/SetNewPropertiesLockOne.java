package com.hcf.learning.demo17;

public class SetNewPropertiesLockOne {
    public static void main(String[] args) {
        try{
            Service2 service2 = new Service2();
            UserInfo userInfo = new UserInfo();

            ThreadC c = new ThreadC(service2, userInfo, "C");
            c.start();
            Thread.sleep(50);
            ThreadD d = new ThreadD(service2, userInfo, "D");
            d.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class UserInfo {
    private String username;
    private String password;

    public UserInfo() {
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Service2 {
    public void serviceMethodA(UserInfo userInfo) {
        synchronized (userInfo) {
            try {
                System.out.println(Thread.currentThread().getName());
                userInfo.setUsername("abcabc");
                Thread.sleep(3000);
                System.out.println("end time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadC extends Thread {
    private Service2 service;
    private UserInfo userInfo;

    public ThreadC(Service2 service, UserInfo userInfo, String name) {
        this.setName(name);
        this.userInfo = userInfo;
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodA(userInfo);
    }
}

class ThreadD extends Thread {
    private Service2 service;
    private UserInfo userInfo;

    public ThreadD(Service2 service, UserInfo userInfo, String name) {
        this.userInfo = userInfo;
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodA(userInfo);
    }
}