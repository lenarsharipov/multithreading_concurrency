package com.apps.mobileappws;

public class Ex02 {
    private final static ThreadLocal<Transaction> TRANSACTION_THREAD_LOCAL = new ThreadLocal<>();

    void m1() {
        TRANSACTION_THREAD_LOCAL.set(new Transaction());
        m2();
    }

    void m2() {
        TRANSACTION_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {

    }

}

class Transaction { // DB transaction

}
