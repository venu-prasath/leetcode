package com.venuprasath.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

import static com.venuprasath.util.Extension.println;

public class LC1116 {

    public static void main(String[] args) {
        ZeroEvenOdd solution = new ZeroEvenOdd(5);
        Thread t1 = new Thread(() -> {
            try {
                solution.zero((int n) -> {
                    println(n);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                solution.odd((int n) -> {
                    println(n);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                solution.even((int n) -> {
                    println(n);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ZeroEvenOdd {
    private int n;
    Semaphore[] semaphores;

    ZeroEvenOdd(int n) {
        this.n = n;
        semaphores = new Semaphore[3];
        try {
            for(int i=0; i<3; i++) {
                semaphores[i] = new Semaphore(1);
                semaphores[i].acquire();
            }
            semaphores[0].release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++) {
            semaphores[0].acquire();
            printNumber.accept(0);
            if(i%2==1) semaphores[2].release();
            else semaphores[1].release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            semaphores[1].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            semaphores[2].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }
}
