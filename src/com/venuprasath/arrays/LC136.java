package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC136 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        LC136 sol = new LC136();
        int res = sol.singleNumber(nums);
        println(res);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
