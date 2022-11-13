package com.hcf.learning.demo35;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<UserInfo> queue = new PriorityBlockingQueue<UserInfo>();
        queue.add(new UserInfo(12));
        queue.add(new UserInfo(13478));
        queue.add(new UserInfo(1569));
        queue.add(new UserInfo(146457));
        queue.add(new UserInfo(11));

        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll());
    }
}

class UserInfo implements Comparable<UserInfo>{
    private int id;
    public UserInfo(){
        super();
    }
    public UserInfo(int id){
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(UserInfo o) {
        if (this.id < o.getId()){
            return -1;
        }
        if (this.id > o.getId()){
            return 1;
        }
        return 0;
    }
}