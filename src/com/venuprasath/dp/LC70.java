package com.venuprasath.dp;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC70 {

    public static void main(String[] args) {
        int n = 20;
        LC70 solution = new LC70();
        int result = solution.climbStairs(n);
        println(result);
    }

    private int climbStairs(int n) {
        return dp(n);
    }

    Map<Integer, Integer> map = new HashMap<>();
    private int dp(int i) {
        if(i<=2) return i;

        if(!map.containsKey(i)) {
            map.put(i, dp(i-1) + dp(i-2));
        }
        return map.get(i);
    }
}
