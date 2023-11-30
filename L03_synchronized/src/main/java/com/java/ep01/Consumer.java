package com.java.ep01;

public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Main.bucket) {
                if (!Main.bucket.isEmpty()) {
                    int value = Main.bucket.get(0);
                    Main.bucket.remove(0);
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " took out the value " + value
                                    + " from the bucket.");
                }
            }
        }
    }
}
