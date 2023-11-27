package com.java.join;

public class Join {
    public static void main(String[] args) {
        // 1
        // query DB1 -> 3 seconds
        // query DB2 -> 2 seconds
        // max (3, 2) = 3 < 5

        // 2
        // processing

        var db1 = new DB1Runnable();
        var db2 = new DB2Runnable();
        var t1 = new Thread(db1);
        var t2 = new Thread(db2);
        t1.start();
        t2.start();

        // t1.setPriority();
        // 1. Never use in apps priority.
        // 2. Jvm accepts priority as advice.
        // 3. Default priority is 5.
        // 4. Min/Max priority is between 1-10 (Min = 1, Max = 10)

        try {
            t1.join(); // Make current thread(main thread) to wait until t1 thread finishes its job
            t2.join(); // Make current thread(main thread) to wait until t2 thread finishes its job
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PROCESSING ..."); // main thread
    }
}
