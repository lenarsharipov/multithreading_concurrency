package com.java.example02;

public class A {
    public void m1() {
        synchronized (this) {
            System.out.println("m1 from A");
        }
    }

    public synchronized void m2() {
        System.out.println("m2 from A");
    }

}
