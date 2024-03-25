package com.venuprasath.reservoir_sampling;

import java.util.*;

import static com.venuprasath.util.Extension.println;

public class LC398 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 3, 4, 4, 4, 1 };
        int answer = pick(3, nums);
        println(answer);
    }

    private static Map<Integer, List<Integer>> map;
    private static Random random;

    private static void initialize(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for(int i=0; i<nums.length; i++) {
            int key = nums[i];
            if(map.containsKey(key)) {
               map.get(key).add(i);
            } else {
                List<Integer> ids = new ArrayList<>();
                ids.add(i);
                map.put(key, ids);
            }
        }
    }

    private static int pick(int target, int[] nums) {
        initialize(nums);
        List<Integer> ids = map.get(target);
        return ids.get(random.nextInt(ids.size()));
    }
}
