package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC875 {

    public static void main(String[] args) {
        //eg - [3,6,7,11]
        int[] piles = new int[] { 3, 6, 7, 11 };
        LC875 solution = new LC875();
        int result = solution.minEatingSpeed(piles, 8);
        print(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;

        while(start < end) {
            int mid = start + (end - start)/2;
            int hr = calculateHours(piles, mid);
            if(hr > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int calculateHours(int[] piles, int speed) {
        int res = 0;
        for(int pile: piles) {
            res += pile/speed;
            if(pile%speed > 0) {
                res++;
            }
        }
        return res;
    }
}
