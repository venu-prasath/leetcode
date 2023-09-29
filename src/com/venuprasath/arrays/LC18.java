package com.venuprasath.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public static void main(String[] args) {
        //[1000000000,1000000000,1000000000,1000000000]
        LC18 sol = new LC18();
        int[] nums = new int[] {1000000000, 1000000000, 1000000000, 1000000000 };
        List<List<Integer>> res = sol.fourSum(nums, -294967296);
        for(List<Integer> outer: res) {
            for(Integer inner: outer) {
                System.out.println(inner);
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-2; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l) {
                    if(k != j+1 && nums[k] == nums[k-1]) {
                        k++;
                        continue;
                    }
                    if(l != n-1 && nums[l] == nums[l+1]) {
                        l--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    } else if(sum < target) {
                        k++;
                        continue;
                    } else {
                        l--;
                        continue;
                    }
                }
            }
        }
        return res;
    }
}
