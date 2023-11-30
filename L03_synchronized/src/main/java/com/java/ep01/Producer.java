package com.java.ep01;

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
                    System.out.println(Thread.currentThread().getName() + " addded value " + n + " to the bucket");
                }
            }
        }
    }

}
