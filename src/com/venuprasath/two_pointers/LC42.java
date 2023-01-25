package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.print;

public class LC42 {

    public static void main(String[] args) {
        //eg - [0,1,0,2,1,0,1,3,2,1,2,1]
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        LC42 solution = new LC42();
        int result = solution.trap(height);
        print(result);
    }

    public int trap(int[] height) {
        int left = 0;
        int leftMax = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int total = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= leftMax) leftMax = height[left];
                else {
                    total = total + leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) rightMax = height[right];
                else {
                    total = total + rightMax - height[right];
                }
                right--;
            }
        }

        return total;
    }
}
