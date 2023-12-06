package com.java.example;

public class Ex01 {

    private Object monitor = new Object();

    public void a() {
        synchronized(monitor) {

        }
    }

    public void b() {
        synchronized(this) {

        }
    }

    // here monitor automatically becomes this.
    public synchronized /* this */ void c() {

    }

    public static synchronized void d() {
    }

    public static void e() {
        synchronized (Ex01.class) {

        }
    }

}