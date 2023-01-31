package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC33 {

    public static void main(String[] args) {
        //eg - [4,5,6,7,0,1,2]
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        LC33 solution = new LC33();
        int result = solution.search(nums, 4);
        print(result);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]) right = mid-1;
                else left = mid+1;
            }
            else{
                if( target > nums[mid] && target <= nums[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}
