package com.apps.mobileappws;

public class Ex01 {

//    static ThreadLocal<Integer> local = new ThreadLocal<>();
    static final ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        local.set(10);
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " : " + local.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        local.set(20);
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " : " + local.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
