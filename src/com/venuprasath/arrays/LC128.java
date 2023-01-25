package com.venuprasath.arrays;

import java.util.HashSet;
import java.util.Set;

import static com.venuprasath.util.Extension.print;

public class LC128 {

    public static void main(String[] args) {
        //eg - [100,4,200,1,3,2]
        int[] nums = { 4, 200, 1, 3, 2 };
        LC128 solution = new LC128();
        int result = solution.longestConsecutive(nums);
        print(result);
    }

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> hashset = new HashSet<>();

        for(int num: nums) {
            hashset.add(num);
        }

        for(int i: nums) {
            int max = 1;
            int prev = i-1;
            int next = i+1;

            while(hashset.contains(prev)) {
                max++;
                hashset.remove(prev--);
            }

            while(hashset.contains(next)) {
                max++;
                hashset.remove(next++);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
