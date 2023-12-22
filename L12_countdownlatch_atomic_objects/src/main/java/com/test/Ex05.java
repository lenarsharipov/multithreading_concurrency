package com.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Ex05 {
    static ReadWriteLock s = new ReentrantReadWriteLock(); // it allows to re-use the same thread. No thread blocking here

    public static void main(String[] args) {
        demo();

    }

    static void demo() {
        try {
            System.out.println(s);
            s.writeLock().lock();
            System.out.println(":)");
            demo();
        } finally {
            s.writeLock().unlock();
        }
    }

}
