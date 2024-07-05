package main.java.service;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int getNextID() {
        return counter.incrementAndGet();
    }
}