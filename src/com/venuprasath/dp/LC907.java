package com.venuprasath.dp;

import java.util.Stack;

import static com.venuprasath.util.Extension.println;

public class LC907 {

    public static void main(String[] args) {
        //[0,3,4,5,2,3,4,1,4]
        int[] arr = {0, 3, 4, 5, 2, 3, 4, 1, 4};
        int result = sumSubarrayMins(arr);
        println(result);
    }

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                int previousSmaller = stack.peek();
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i];
            } else {
                dp[i] = (i + 1) * arr[i];
            }
            stack.push(i);
        }

        long sumOfMinimums = 0;
        for (int count : dp) {
            sumOfMinimums += count;
            sumOfMinimums %= MOD;
        }

        return (int) sumOfMinimums;
    }
}


