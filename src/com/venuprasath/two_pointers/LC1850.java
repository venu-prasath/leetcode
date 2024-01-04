package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC1850 {

    public static void main(String[] args) {
        String num = "5489355142";
        int result = getMinSwaps(num, 4);
        println(result);
    }

    private static int getMinSwaps(String num, int k) {
        int n = num.length();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            int digit = num.charAt(i) - '0';
            nums[i] = digit;
        }
        int[] original = new int[n];
        for(int i=0; i<n; i++) {
            original[i] = nums[i];
        }
        int count = 0;
        int[] result = nums;
        while(count < k) {
            result = nextPerm(nums, n);
            count++;
        }
        return getMinSwaps(original, result);
    }

    private static int getMinSwaps(int[] orignal, int[] result) {
        int n = orignal.length;
        int swapCount = 0;
        for(int i=0; i<n; i++) {
            if(orignal[i] == result[i]) continue;
            int j = i+1;
            while(j<n && orignal[i] != result[j]) j++;
            while(j>i) {
                swap(result, j-1, j);
                swapCount++;
                j--;
            }
        }

        return swapCount;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int[] nextPerm(int[] nums, int n) {
        int pivot = n-1;
        while(pivot >=1 && nums[pivot] <= nums[pivot-1]) pivot--;
        if(pivot != 0) {
            int j = n-1;
            while(nums[j] <= nums[pivot-1]) j--;
            swap(nums, j, pivot-1);
        }
        int left = pivot;
        int right = n-1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }
}
