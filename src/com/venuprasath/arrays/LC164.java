package com.venuprasath.arrays;

import java.util.Arrays;

import static com.venuprasath.util.Extension.println;

public class LC164 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, 1, 5, 7, 8, 33, 11, 23, 23};
        int result = maximumGap(nums);
        println(result);
    }

    public static int maximumGap(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(max < nums[i] - nums[i-1]) {
                max = nums[i] - nums[i-1];
            }
        }
        return max;
    }
}
