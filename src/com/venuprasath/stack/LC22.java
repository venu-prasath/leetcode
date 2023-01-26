package com.venuprasath.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.venuprasath.util.Extension.print;

public class LC22 {

    public static void main(String[] args) {
        int n=3;

        LC22 solution = new LC22();
        List<String> output = solution.generateParenthesis(n);
        for(String str: output) {
            print(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, 0, 0, "", n);
        return result;
    }

    private void generate(List<String> result, int left, int right, String s, int n) {
        if(s.length() == n*2) {
            if(isValid(s)) {
                result.add(s);
            }
            return;
        }
        if(left < n) {
            generate(result, left+1, right, s+"(", n);
        }
        if(right < n) {
            generate(result, left, right+1, s+")", n);
        }
    }

    private boolean isValid(String s) {
        boolean isValid = false;
        Stack<Character> stack = new Stack();

        char[] chArray = s.toCharArray();
        for(char ch: chArray) {
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
            } else if(ch == ']') {
                char stackTop = stack.peek();
                if(stackTop == '[') {
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
