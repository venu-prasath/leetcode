package com.venuprasath.arrays;

import java.util.PriorityQueue;

public class LC2558 {

    public static void main(String[] args) {
        int[] gifts = new int[] {25, 64, 9, 4, 100 };
        LC2558 sol = new LC2558();
        long result = sol.pickGifts(gifts, 4);
        System.out.println(result);
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = createPriorityQueue(gifts);

        for(int i = 0; i<k; i++) {
            Integer gift = heap.poll();
            double sqrtGift = Math.sqrt(gift);
            heap.add((int)sqrtGift);
        }
        long count = 0L;
        while(!heap.isEmpty()) {
            count += heap.poll();
        }
        return count;
    }

    public PriorityQueue<Integer> createPriorityQueue(int[] gifts) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> b - a);
        for(int gift: gifts) {
            heap.add(gift);
        }
        return heap;
    }
}
