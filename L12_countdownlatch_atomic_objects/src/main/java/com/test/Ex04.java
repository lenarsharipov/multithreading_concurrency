package com.test;

import java.util.concurrent.Semaphore;

public class Ex04 {
    static Semaphore s = new Semaphore(1);

    public static void main(String[] args) {
        demo();

    }

    static void demo() {
        try {
            System.out.println(s);
            s.acquire();
            System.out.println(":)");
            demo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.release();
        }
    }

}
