package com.venuprasath.concurrency;

import java.util.concurrent.Semaphore;

import static com.venuprasath.util.Extension.println;

public class LC1117 {
    public static void main(String[] args) {
        H2O sol = new H2O();

        Thread thread1  = new Thread(() -> {
            try {
                sol.hydrogen(() -> println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2  = new Thread(() -> {
            try {
                sol.oxygen(() -> println("O"));
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

class H2O {
    private final Semaphore hSem;
    private final Semaphore oSem;

    public H2O() {
        hSem = new Semaphore(2, true);
        oSem = new Semaphore(0, true);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSem.acquire();
        releaseHydrogen.run();
        oSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire(2);
        releaseOxygen.run();
        hSem.release(2);
    }
}
