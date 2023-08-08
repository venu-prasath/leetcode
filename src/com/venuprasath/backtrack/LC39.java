package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39 {

    //[2,3,6,7], [7]
    public List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates, res, new ArrayList(), target, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int remain, int idx) {
        if(remain < 0) return;
        else if(remain == 0) res.add(new ArrayList(curr));
        else {
            for(int i=idx; i<nums.length; i++) {
                curr.add(nums[i]);
                backtrack(nums, res, curr, remain-nums[i], i);
                curr.remove(curr.size()-1);
            }
        }
    }
}
