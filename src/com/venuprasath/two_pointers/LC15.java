package com.venuprasath.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

    public static void main(String[] args) {
        //eg - [-1,0,1,2,-1,-4]
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        LC15 solution = new LC15();
        List<List<Integer>> result = solution.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                if(j!=i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if(k!=nums.length-1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                int total = nums[i] + nums[j] + nums[k];
                if(total == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if(total < 0) {
                    j++;
                    continue;
                } else {
                    k--;
                    continue;
                }
            }
        }

        return result;
    }
}
