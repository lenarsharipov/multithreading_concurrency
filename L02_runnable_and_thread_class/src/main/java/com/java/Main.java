package com.java;

public class Main {
    public static void main(String[] args) {
        var r1 = new OddNumbersRunnable();
        var t1 = new Thread(r1, "T1-thread"); // NEW
        var t2 = new Thread(r1, "T2-thread"); // NEW
        t1.start(); // NEW -> RUNNABLE
        t2.start(); // NEW -> RUNNABLE

        System.out.println("END" + " " + Thread.currentThread().getName());
    }
}