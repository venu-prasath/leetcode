package com.venuprasath.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

import static com.venuprasath.util.Extension.println;

public class LC1195 {

    public static void main(String[] args) {
        FizzBuzz2 sol = new FizzBuzz2(15);
        Thread t1 = new Thread(() -> {
            try {
                sol.fizz(()-> {
                    println("fizz ");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                sol.buzz(()-> {
                    println("buzz ");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                sol.fizzBuzz(()-> {
                    println("fizzbuzz ");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                sol.number((int n)-> {
                    println(n+" ");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}

class FizzBuzz2 {
    private int n;
    Semaphore[] semaphores;

    FizzBuzz2(int n) {
        this.n = n;
        semaphores = new Semaphore[4];

        for(int i=0; i<4; i++) {
            semaphores[i] = new Semaphore(1, true);
            try {
                semaphores[i].acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        semaphores[3].release();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=1; i<=n; i++) {
            if(i % 3 == 0 && i % 5 != 0) {
                semaphores[0].acquire();
                printFizz.run();
                release(i);
            }
        }
    }

    public  void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=1; i<=n; i++) {
            if(i % 3 != 0 && i % 5 == 0) {
                semaphores[1].acquire();
                printBuzz.run();
                release(i);
            }
        }
    }

    public void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=1; i<=n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                semaphores[2].acquire();
                printFizzBuzz.run();
                release(i);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++) {
            if(i % 3 != 0 && i % 5 != 0) {
                semaphores[3].acquire();
                printNumber.accept(i);
                release(i);
            }
        }
    }

    private void release(int n) {
        int next = n+1;
        if(next % 5 == 0 && next % 3 == 0) semaphores[2].release();
        else if(next % 5 == 0) semaphores[1].release();
        else if(next % 3 == 0) semaphores[0].release();
        else semaphores[3].release();
    }
}
