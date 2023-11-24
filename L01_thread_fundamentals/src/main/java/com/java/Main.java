package com.java;

public class Main {
    public static void main(String[] args) {
        System.out.println("thread info: " + Thread.currentThread());
        var t1 = new EvenNumbersThread();
        System.out.println(t1.getState());
        t1.start(); // EvenNumbersThread class' run() executed in new Thread
        t1.run(); // EvenNumbersThread class' run() executed in main Thread. New thread not created.
        System.out.println("END!");
    }
}