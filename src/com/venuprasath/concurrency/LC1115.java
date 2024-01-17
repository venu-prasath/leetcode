package com.venuprasath.concurrency;

import java.util.concurrent.Semaphore;

import static com.venuprasath.util.Extension.print;

public class LC1115 {

    public static void main(String[] args) {
        Foobar foobar = new Foobar();

        Thread thread1 = new Thread(() -> {
            try {
                foobar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foobar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Foobar {
    int n;
    Semaphore[] semaphores;
    public Foobar() {
        this.n = 10;
        semaphores = new Semaphore[2];
        try {
            for(int i=0; i<2; i++) {
                semaphores[i] = new Semaphore(1, true);
                semaphores[i].acquire();
            }
            semaphores[0].release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void foo() throws InterruptedException {
        for(int i=0; i<n; i++) {
            semaphores[0].acquire();
            print("foo");
            semaphores[1].release();
        }
    }

    public void bar() throws InterruptedException {
        for(int i=0; i<n; i++) {
            semaphores[1].acquire();
            print("bar");
            semaphores[0].release();
        }
    }
}
