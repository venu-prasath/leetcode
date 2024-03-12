package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class SingleNumber1 {

    public static void main(String[] args) {
        int[] nums = { 5, 1, 2, 1, 2 };
        int result = findDuplicate(nums);
        println(result);
    }

    public static int findDuplicate(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result ^= num;
        }
        return result;
    }
}
