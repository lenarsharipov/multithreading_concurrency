package com.java.example02;

public class Ex02 {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();

        Thread t1 = new Thread(a::m1);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                b.m1();
            }
        };

        t1.start();
        t2.start();
    }
}
