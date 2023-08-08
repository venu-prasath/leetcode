package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {

    public List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates, res, new ArrayList(), target, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int remain, int idx) {
        if(remain < 0) return;
        else if(remain == 0) res.add(new ArrayList<>(curr));
        else {
            for(int i=0; i<nums.length; i++) {
                if(i>idx && nums[i] == nums[i-1]) continue;
                curr.add(nums[i]);
                backtrack(nums, res, curr, remain-nums[i], i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}
