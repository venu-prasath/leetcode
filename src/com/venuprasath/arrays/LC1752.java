package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC1752 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        LC1752 sol = new LC1752();
        boolean result = sol.check(nums);
        println(result);
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        if(n <= 1) return true;
        int i = 0;
        int j = i+1;
        int count = 0;
        while(j <= n-1) {
            if(nums[i] > nums[j]) {
                count++;
            }
            i++;
            j++;
        }
        if(count == 0) return true;
        else if(count > 1) return false;
        else if(nums[0] >= nums[n-1]) return true;
        else return false;
    }
}
