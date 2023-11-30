package com.java.ep02.ex1;

import java.util.Random;
public class Producer extends Thread {

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (Main.bucket) {
                if (Main.bucket.size() < 100) {
                    int n = random.nextInt(1000); // [0, 999]
                    Main.bucket.add(n);
                    Main.bucket.notifyAll();
                    System.out.println(Thread.currentThread().getName() + " addded value " + n + " to the bucket");
                } else {
                    try {
                        Main.bucket.wait(); // makes thread blocked
                        GetAllThreads.showThreads();
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // producer waits now
                    }
                }
            }
        }
    }

}
