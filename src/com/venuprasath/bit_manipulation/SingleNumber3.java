package com.venuprasath.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

import static com.venuprasath.util.Extension.println;

public class SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 2, 14, 8, 7, 7, 8 };
        int[] result = find(nums);
        for(int num: result) {
            println(num + "\t");
        }
    }

    /*
    TC: O(2N)
    SC: O(1)
     */
    public static int[] find(int[] nums) {
        int xor = 0;
        for(int num: nums) {
            xor ^= num;
        }
        int rightMost = (xor & (xor-1)) & xor;
        int b1 = 0;
        int b2 = 0;
        for(int num: nums) {
            if((num & rightMost) != 0) {
                b1 = b1 ^ num;
            } else {
                b2 = b2 ^ num;
            }
        }
        return new int[] {b1, b2 };
    }
}
