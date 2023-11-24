package com.java;

public class EvenNumbersThread extends Thread {
    @Override
    public void run() { // main method of a thread
        System.out.println("t1 thread's status: " + Thread.currentThread().getState());
        try {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println(i);
                System.out.println(Thread.currentThread());
                Thread.sleep(1000); // Now thread's state is TIMED_WAITING
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}