package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        LC75 solution = new LC75();
        solution.sortColors(nums);
        for(int i=0; i<nums.length; i++) {
            println(nums[i]);
        }
    }

    private void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i=0;
        while(i<=right) {
            if(nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
            if(nums[i] == 2) {
                swap(nums, right, i);
                right--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
