package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC704 {

    public static void main(String[] args) {
        //eg - [-1,0,3,5,9,12]
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        LC704 solution = new LC704();
        int result = solution.search(nums, 12);
        print(result);
    }

    public int search(int[] nums, int target) {
        int result = 0;
        int first = 0;
        int last = nums.length - 1;

        while(first <= last) {
            int mid = (first + (last - first)/2);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                first = mid+1;
            } else {
                last = mid-1;
            }
        }
        return result;
    }
}
