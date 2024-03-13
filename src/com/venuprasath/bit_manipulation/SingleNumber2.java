package com.venuprasath.bit_manipulation;

import java.util.Arrays;

import static com.venuprasath.util.Extension.println;

public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 2, 4, 4, 4 };
        int result = magicSolution(nums);
        println(result);
    }

    /*
    Time Complexity: O(N * 32)
    Space Complexity: O(1)
     */
    public static int find(int[] nums) {
        int ans = 0;

        for(int i=0; i<32; i++) {
            int count = 0;
            for(int num: nums) {
                count += (num >> i) & 1;
            }
            count %= 3;
            ans |= count << i;
        }

        return ans;
    }

    /*
    Time Complexity: O(Nlog(N) + N/3)
    Space Complexity: O(1)
     */
    public static int find2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i += 3) {
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

    public static int magicSolution(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int num: nums) {
            ones = ones ^ (num & ~twos);
            twos = twos ^ (num & ~ones);
        }
        return ones;
    }
}
