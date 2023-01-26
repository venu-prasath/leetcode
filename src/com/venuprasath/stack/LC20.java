package com.venuprasath.stack;

import java.util.Stack;

import static com.venuprasath.util.Extension.print;

public class LC20 {

    public static void main(String[] args) {
        //eg - "()"
        String s = "{}[](())";
        LC20 solution = new LC20();
        boolean result = solution.isValid(s);
        print(result);
    }

    public boolean isValid(String s) {
        boolean isValid = false;
        Stack<Character> stack = new Stack();

        char[] charArray = s.toCharArray();
        for(char ch: charArray) {
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if(ch == ')') {
                char stackTop = stack.peek();
                if(stackTop == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else if(ch == '}') {
                char stackTop = stack.peek();
                if(stackTop == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else if(ch == ']') {
                char stackTop = stack.peek();
                if(stackTop == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }

        if(stack.isEmpty()) {
            isValid = true;
        }

        return isValid;
    }
}
