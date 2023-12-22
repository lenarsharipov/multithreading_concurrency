package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex06 {
    public static void main(String[] args) {
        // AtomicBoolean
        // AtomicInteger
        // AtomicLong
        // AtomicReference

        AtomicInteger i1 = new AtomicInteger(1);
        int res = i1.addAndGet(3);

        System.out.println(res);
    }
}

class MyNumber {
    private int x;

    public int addAndGet(int v) {
        x += v;
        return x;
    }

}
