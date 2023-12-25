package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC485 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 1, 1, 1, 0, 1};
        LC485 sol = new LC485();
        int res = sol.findMaxConsecutiveOnes(nums);
        println(res);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentCount = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                currentCount++;
            } else {
                if(currentCount > max) {
                    max = currentCount;
                }
                currentCount = 0;
            }
        }
        if(currentCount > max) return currentCount;
        return max;
    }
}
