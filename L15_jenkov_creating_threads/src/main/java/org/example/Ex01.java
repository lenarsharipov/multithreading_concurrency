package org.example;

public class Ex01 {

    public static void main(String[] args) {
        var t1 = new MyThread();
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.run();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }
}


