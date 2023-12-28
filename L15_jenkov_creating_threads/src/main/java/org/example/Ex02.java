package org.example;

public class Ex02 {

    public static void main(String[] args) {
        var t1 = new Thread(new MyRunnable());
        t1.start();
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }

    }

}
