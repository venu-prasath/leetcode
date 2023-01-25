package com.venuprasath.two_pointers;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.print;

public class LC167 {

    public static void main(String[] args) {
        //eg - [2,7,11,15]
        int[] nums = { 2, 7, 11, 15 };
        LC167 solution = new LC167();
        int[] result = solution.twoSum(nums, 9);
        for(int i: result) {
            print(i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int i = 0;
        int j = numbers.length-1;

        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
