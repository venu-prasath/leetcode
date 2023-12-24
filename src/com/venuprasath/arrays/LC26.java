package com.venuprasath.arrays;

public class LC26 {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 3, 3, 4 };
        LC26 sol = new LC26();
        System.out.println(sol.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}
