package org.example;

public class Ex04 {

    public static void main(String[] args) {
        var r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " finished");
            }
        };

        var t1 = new Thread(r);
        t1.start();

    }

}
