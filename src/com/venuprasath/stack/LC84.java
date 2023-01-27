package com.venuprasath.stack;

import java.util.Stack;

import static com.venuprasath.util.Extension.print;

public class LC84 {

    public static void main(String[] args) {
        //eg - ht = [2,1,5,6,2,3]
        int[] ht = new int[] { 2, 4 }; //{ 2, 1, 5, 6, 2, 3 };
        LC84 solution = new LC84();
        int result = solution.largestRectangleArea(ht);
        print(result);
    }

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<= size; i++) {
            int curr = i==size ? 0: heights[i];
            while(!stack.isEmpty() && curr < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
