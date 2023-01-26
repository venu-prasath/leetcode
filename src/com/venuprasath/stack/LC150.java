package com.venuprasath.stack;

import java.util.Stack;

import static com.venuprasath.util.Extension.print;

public class LC150 {

    public static void main(String[] args) {
        //eg - ["2","1","+","3","*"]
        String[] tokens = new String[] { "4", "13", "5", "/", "+" };
        LC150 solution = new LC150();
        int result = solution.evalRPN(tokens);
        print(result);
    }

    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<String> stack = new Stack();

        for(String str: tokens) {
            switch (str) {
                case "+" -> {
                    int op1 = Integer.parseInt(stack.pop());
                    int op2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 + op2));
                    break;
                }
                case "-" -> {
                    int op1 = Integer.parseInt(stack.pop());
                    int op2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op2 - op1));
                    break;
                }
                case "*" -> {
                    int op1 = Integer.parseInt(stack.pop());
                    int op2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op1 * op2));
                    break;
                }
                case "/" -> {
                    int op1 = Integer.parseInt(stack.pop());
                    int op2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(op2 / op1));
                    break;
                }
                default -> stack.push(str);
            }
        }

        result = Integer.parseInt(stack.pop());
        return result;
    }
}
