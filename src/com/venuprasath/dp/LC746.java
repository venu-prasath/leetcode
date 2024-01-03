package com.venuprasath.dp;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC746 {
    Map<Integer, Integer> map = new HashMap();
    int[] costs;
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        LC746 solution = new LC746();
        int result = solution.minCost(cost);
        println(result);
        println("\n");
        int result2 = solution.minCost2(cost);
        println(result2);
    }

    private int minCost(int[] cost) {
        this.costs = cost;
        return dp(cost.length);
    }

    private int dp(int i) {
        if(i<2) return 0;
        int lastStepCost = costs[i-1] + dp(i-1);
        int secondLastStepCost = costs[i-2] + dp(i-2);
        if(!map.containsKey(i)) {
            map.put(i, Math.min(lastStepCost, secondLastStepCost));
        }
        return map.get(i);
    }

    private int minCost2(int[] cost) {
        int[] costs = new int[cost.length+1];
        for(int i=2; i<costs.length; i++) {
            int lastStepCost = cost[i-1] + costs[i-1];
            int secondLastStepCost = cost[i-2] + costs[i-2];
            costs[i] = Math.min(lastStepCost, secondLastStepCost);
        }
        return costs[costs.length-1];
    }
}
