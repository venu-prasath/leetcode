package com.venuprasath.stack;

import java.util.Stack;

import static com.venuprasath.util.Extension.print;

public class LC739 {

    public static void main(String[] args) {
        //eg - [73,74,75,71,69,72,76,73]
        int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73 };
        LC739 solution = new LC739();
        int[] result = solution.dailyTemperatures(temp);
        for(int i: result) {
            print(i);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()])
            {
                st.pop();
            }
            if(!st.isEmpty())
                res[i]=st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
