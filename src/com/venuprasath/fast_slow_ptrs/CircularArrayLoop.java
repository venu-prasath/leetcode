package com.venuprasath.fast_slow_ptrs;

public class CircularArrayLoop {

    public static void main(String[] args) {

    }

    public static boolean hasLoop(int[] nums) {
        int size = nums.length;
        for(int i=0; i<size; i++) {
            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;
            while(true) {
                slow = nextStep(slow, nums[slow], size);
                if(isNotCycle(forward, slow, nums)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], size);
                if(isNotCycle(forward, fast, nums)) {
                    break;
                }
                fast = nextStep(fast, nums[fast], size);
                if(isNotCycle(forward, fast, nums)) {
                    break;
                }
                if(slow == fast) {
                    return true;
                }
            }

        }
        return false;
    }

    public static int nextStep(int position, int value, int size) {
        int result = (position + value) % size;
        if(result < 0) {
            result += size;
        }
        return result;
    }

    public static boolean isNotCycle(boolean prevDirection, int position, int[] nums) {
        boolean currentDirection = nums[position] >= 0;
        if(prevDirection != currentDirection || Math.abs(nums[position] - nums.length) == 0) {
            return true;
        }
        return false;
    }
}
