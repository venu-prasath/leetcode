package com.venuprasath.arrays;

import java.util.HashMap;

public class LC217 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 1, 2, 3, 1 };
        boolean answer = solution.containsDuplicate(nums);
        System.out.println(answer);
    }
}


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, true);
            }
        }
        return false;
    }
}