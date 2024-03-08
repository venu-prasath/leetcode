package com.venuprasath.fast_slow_ptrs;

public class FindDuplicate {

    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}
