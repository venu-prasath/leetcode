package com.venuprasath.arrays;

import java.util.Arrays;

import static com.venuprasath.util.Extension.println;

public class LC645 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = findErrorNums(nums);
        println(result[0] + ", " + result[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for(int i=1; i< nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                dup = nums[i];
            }
            else if(nums[i] > nums[i-1]+1) {
                missing = nums[i-1]+1;
            }
        }
        return new int[] {dup, nums[nums.length-1] != nums.length ? nums.length: missing};
    }
}
