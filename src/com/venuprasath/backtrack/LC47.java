package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, res, new ArrayList(), new boolean[nums.length]);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] used) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                curr.add(nums[i]);
                permute(nums, res, curr, used);
                curr.remove(curr.size()-1);
            }
        }
    }
}
