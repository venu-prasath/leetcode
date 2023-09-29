package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC90 {

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(nums, res, new ArrayList(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx) {
        res.add(new ArrayList(curr));
        for(int i=idx; i<nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(nums, res, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
