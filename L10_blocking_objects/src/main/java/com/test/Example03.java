package com.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Example03 {
//    int n;
//
//    public synchronized void increment() {
//        n++;
//    }
//
//    public synchronized int get() {
//        return n;
//    }

    int n;

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {
        try {
            lock.writeLock().lock(); // similar to acquire of Semaphore
            n++; // if any thread here then no any thread is able to either increment() or get()
        } finally {
            lock.writeLock().unlock(); // similar to release of Semaphore
        }
    }

    public int get() {
        try {
            lock.readLock().lock(); // similar to acquire of Semaphore
            return n; // T1 T2 T3 ...
        } finally {
            lock.readLock().unlock(); // similar to release of Semaphore
        }
    }

}
