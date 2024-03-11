package com.venuprasath.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

import static com.venuprasath.util.Extension.println;

public class PowerSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> answer = check(nums);
        for(List<Integer> subList: answer) {
            if(subList.isEmpty()) {
                println("[]\t");
                continue;
            }
            for(Integer val: subList) {
                println(val);
            }
            println("\t");
        }
    }

    private static List<List<Integer>> check(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        int subsets = 1 << n;

        for(int i = 0; i < subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            answer.add(list);
        }

        return answer;
    }
}
