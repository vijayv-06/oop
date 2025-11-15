package com.Day8CW;

class MyThread extends Thread{
    public void run(){
        System.out.println("MyThread is running: "+Thread.currentThread().getName());
    }
}

public class ByExtendingThreadClass {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();
    }
}


class MyThread1 implements Runnable{

    @Override
    public void run() {
        System.out.println("My thread is running: "+Thread.currentThread().getName());
    }
}

