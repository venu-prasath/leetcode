package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC189 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        LC189 sol = new LC189();
        sol.rotateBy(nums, 3);
        for(int i=0; i<nums.length; i++) {
            println(nums[i]);
        }
    }

    private void rotateBy(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;
        rotate(nums, 0, n-d-1);
        rotate(nums, n-d, n-1);
        rotate(nums, 0, n-1);
    }

    private void rotate(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
