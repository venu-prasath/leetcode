package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList());
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(curr.contains(nums[i])) continue;
                curr.add(nums[i]);
                permute(nums, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
