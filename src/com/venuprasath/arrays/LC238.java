package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.print;

public class LC238 {

    public static void main(String[] args) {

        //eg - [1,2,3,4]
        int[] nums = { 1, 2, 3, 4 };
        LC238 solution = new LC238();
        int[] result = solution.productExceptSelf(nums);
        for(int num: result) {
            print(num + "");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int answer[] = new int[size];

        for(int i = 0, left = 1; i<size; i++) {
            answer[i] = left;
            left = left * nums[i];
        }

        // [1,1,2,6]
        for(int i = size -1, right = 1; i>=0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }
}
