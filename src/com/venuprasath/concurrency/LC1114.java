package com.venuprasath.concurrency;

import java.util.concurrent.Semaphore;
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

    Semaphore[] semaphores;
    int numOfThreads = 3;
    Foo() {
        semaphores = new Semaphore[numOfThreads];
        try {
            for(int i=0; i<numOfThreads; i++) {
                semaphores[i] = new Semaphore(1, true);
                semaphores[i].acquire();
            }
            semaphores[0].release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphores[0].acquire();
        printFirst.run();
        semaphores[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphores[1].acquire();
        printSecond.run();
        semaphores[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphores[2].acquire();
        printThird.run();
        semaphores[0].release();
    }
}
