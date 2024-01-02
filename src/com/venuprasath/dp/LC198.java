package com.venuprasath.dp;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC198 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        LC198 sol = new LC198();
        int result = sol.rob(nums);
        println(result);
    }

    int[] nums;
    Map<Integer, Integer> map = new HashMap<>();
    private int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length-1);
    }

    private int dp(int i) {
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);

        if(!map.containsKey(i)) {
            map.put(i, Math.max(dp(i-1), dp(i-2) + nums[i]));
        }
        return map.get(i);
    }

}
