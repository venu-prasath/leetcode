package com.venuprasath.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import static com.venuprasath.util.Extension.println;

public class LC1188 {

    public static void main(String[] args) {
        BoundedBlockingQueue q = new BoundedBlockingQueue(2);

        Thread prod = new Thread(() -> {
            try {
                q.enqueue(1);
                q.enqueue(0);
                q.enqueue(2);
                q.enqueue(3);
                q.enqueue(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread cons = new Thread(() -> {
            try {
                println(q.dequeue());
                println(q.dequeue());
                println(q.dequeue());
                println(q.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        prod.start();
        cons.start();

        try {
            prod.join();
            cons.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

class BoundedBlockingQueue {
    private final Semaphore enq;
    private final Semaphore deq;
    private Queue<Integer> queue;

    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
    }

    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        queue.offer(element);
        deq.release();
    }

    public int dequeue() throws InterruptedException {
        deq.acquire();
        int ans = queue.poll();
        enq.release();
        return ans;
    }

    public int size() {
        return queue.size();
    }
}
