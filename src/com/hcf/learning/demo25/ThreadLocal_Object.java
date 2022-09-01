package com.hcf.learning.demo25;

public class ThreadLocal_Object {
    public static void main(String[] args) throws InterruptedException {
        UserInfo1 userInfo = new UserInfo1();
        System.out.println("A userInfo "+userInfo.hashCode());
        userInfo.setUsername("AAA");
        if (Tools4.t1.get()==null){
            Tools4.t1.set(userInfo);
        }
        System.out.println("in main thread: "+Tools4.t1.get().getUsername()+" "+Tools4.t1.get().hashCode());
        Thread.sleep(100);
        ThreadE threadE = new ThreadE();
        threadE.start();
        Thread.sleep(5000);
        Tools4.t1.get().setUsername("BBB");
    }
}

class UserInfo1{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class Tools4{
    public static InheritableThreadLocal<UserInfo1> t1 = new InheritableThreadLocal<>();

}

class ThreadE extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                UserInfo1 userInfo1 = Tools4.t1.get();
                System.out.println("get by ThreadE: "+Tools4.t1.get().getUsername()+ " "+Tools4.t1.get().hashCode());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}