package com.venuprasath.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

import static com.venuprasath.util.Extension.println;

public class LC1114 {

    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread thread1  = new Thread(() -> {
            try {
                foo.first(() -> println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2  = new Thread(() -> {
            try {
                foo.second(() -> println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3  = new Thread(() -> {
            try {
                foo.third(() -> println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(firstJobDone.get() != 1) {}
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(secondJobDone.get() != 1) {}
        printThird.run();
    }
}
