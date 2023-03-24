package com.venuprasath.recursion;

import static com.venuprasath.util.Extension.print;

public class Staircase {

    public static void main(String[] args) {
        Staircase sol = new Staircase();
        int answer = sol.numberOfWaysIterative(4);
        print(answer);
        answer = sol.numberOfWaysRecursive(4);
        print(answer);
    }


    public int numberOfWaysIterative(int n) {
        int a = 1;
        int b = 1;

        for(int i=1; i<=n; i++) {
            int nextB = a + b;
            a = b;
            b = nextB;
        }
        return b;
    }

    public int numberOfWaysRecursive(int n) {
        if(n <= 1) return n;
        return numberOfWaysRecursive(n-1) + numberOfWaysRecursive(n-2);
    }


}
