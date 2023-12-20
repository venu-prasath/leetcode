package com.venuprasath.arrays;

public class LC26 {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 3, 3, 4 };
        LC26 sol = new LC26();
        System.out.println(sol.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != nums[j]) {
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
