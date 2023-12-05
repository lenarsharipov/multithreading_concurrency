package com.java.example04;

public class Example04 {
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
        synchronized (a) {
            synchronized (b) {

            }
        }
    }
}
