package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC268 {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        LC268 sol = new LC268();
        int result = sol.findMissing(nums);
        println(result);
    }

    private int findMissing(int[] nums) {
        int n = nums.length;
        int sum1 = (n*(n+1))/2;
        int sum2 = 0;
        for(int i=0; i<n; i++) sum2 += nums[i];
        return sum1-sum2;
    }
}
