package org.example;

public class Ex03 {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Runnable running");
                System.out.println("Runnable finished");
            }
        };

        Thread t = new Thread(r, "My runnable**********");
        t.start();

        Runnable r2 = () -> {
            System.out.println("Runnable running");
            System.out.println("Runnable finished");
        };

        Thread t2 = new Thread(r2);
        t2.start();
    }
}
