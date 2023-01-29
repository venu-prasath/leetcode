package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC153 {

    public static void main(String[] args) {
        //eg - [3,4,5,1,2]
        int[] nums = new int[] { 3, 4, 5, 1, 2 };
        LC153 solution = new LC153();
        int result = solution.findMin(nums);
        print(result);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else if(nums[mid] < nums[right]) right = mid;
            else return nums[right];
        }
        return nums[left];
    }
}
