package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(nums, res, new ArrayList(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx) {
        res.add(new ArrayList(curr));
        for(int i=0; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, res, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }


}
