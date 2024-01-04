package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC31 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        println("Current Perm: \n");
        for(int num: nums) {
            println(num);
        }
        nextPerm(nums);
        println("\nNext perm: \n");
        for(int num: nums) {
            println(num);
        }
    }

    private static void nextPerm(int[] nums) {
        int n = nums.length;
        int pivot = n-1;
        while(pivot >= 1 && nums[pivot] <= nums[pivot-1]) {
            pivot--;
        }
        if(pivot != 0) {
            int j = n-1;
            while(nums[j] <= nums[pivot-1]) j--;
            swap(nums, pivot-1, j);
        }
        int left = pivot;
        int right = n-1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
