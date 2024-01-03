package com.venuprasath.dp;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC1137 {

    public static void main(String[] args) {
        int n = 25;
        LC1137 solution = new LC1137();
        int result = solution.trib(n);
        println(result);
    }

    private int trib(int n) {
        return dp(n);
    }

    Map<Integer, Integer> map = new HashMap<>();
    private int dp(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;

        if(!map.containsKey(n)) {
            map.put(n, dp(n-1) + dp(n-2) + dp(n-3));
        }
        return map.get(n);
    }
}
