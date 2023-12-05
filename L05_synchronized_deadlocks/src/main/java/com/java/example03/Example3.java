package com.java.example03;

public class Example3 {

    private Object a = new Object();
    private Object b = new Object();

    public void m1() {
        // T3
        synchronized (a) {
            // T1
            synchronized (b) {

            }
        }
    }

    public void m2() {
        // T2
        synchronized (b) {
            synchronized (a) {

            }
        }
    }

}
