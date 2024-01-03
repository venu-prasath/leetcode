package com.venuprasath.dp;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC740 {

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 3, 3, 4 };
        int result = deleteAndEarn(nums);
        println(result);
    }

    private static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(num, maxNum);
        }
        return maxPoints(maxNum);
    }

    static Map<Integer, Integer> points = new HashMap<>();
    static Map<Integer, Integer> cache = new HashMap<>();
    private static int maxPoints(int n) {
        if(n == 0) return 0;
        if(n == 1) return points.getOrDefault(n, 0);

        if(!cache.containsKey(n)) {
            int gain = points.getOrDefault(n, 0);
            cache.put(n, Math.max(maxPoints(n-1), maxPoints(n-2) + gain));
        }
        return cache.get(n);
    }
}
