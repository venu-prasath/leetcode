package com.venuprasath.math;

import static com.venuprasath.util.Extension.println;

public class LC509 {

    public static void main(String[] args) {
        int n = 5;
        LC509 sol = new LC509();
        int result = sol.fib(n);
        println(result);
    }

    private int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
}
