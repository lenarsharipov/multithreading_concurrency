package com.java.ep02.ex1;

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
                    Main.bucket.notifyAll();
                    System.out.println(Thread.currentThread().getName() + " removed "
                            + value  + " from the bucket."
                    );
                } else {
                    try {
                        Main.bucket.wait(); // makes thread blocked
                        GetAllThreads.showThreads();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
