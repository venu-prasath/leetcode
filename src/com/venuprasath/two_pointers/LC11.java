package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.print;

public class LC11 {

    public static void main(String[] args) {
        //eg - [1,8,6,2,5,4,8,3,7]
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7 };
        LC11 solution = new LC11();
        int result = solution.maxArea(nums);
        print(result);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;

        while(i<j) {
          int area = minOf(height[i], height[j]) * (j-i);
          if(area > max) {
              max = area;
          }
          if(height[i] < height[j]) {
              i++;
          } else {
              j--;
          }
        }
        return max;
    }

    private int minOf(int i, int j) {
        if(i<j) {
            return i;
        } else {
            return j;
        }
    }
}
