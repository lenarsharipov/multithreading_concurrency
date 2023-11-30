package com.java.ep01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final List<Integer> bucket = new ArrayList<>();

    public static void main(String[] args) {
        var producer = new Producer("producer");
        var producer2 = new Producer("producer2");
        var consumer = new Consumer("consumer");
        var consumer2 = new Consumer("consumer2");

        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();
    }

}