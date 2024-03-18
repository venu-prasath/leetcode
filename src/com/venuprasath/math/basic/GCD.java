package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class GCD {

    public static void main(String[] args) {
        int a = 9;
        int b = 12;
        int res = gcd(a, b);
        println(res + "\n");
        res = euclideanGcd(a, b);
        println(res);
    }

    public static int gcd(int a, int b) {
        int gcd = 1;
        for(int i=1; i<=Math.min(a, b); i++) {
            if(a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int euclideanGcd(int a, int b) {
        while(a > 0 && b > 0) {
            if(a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        if (a == 0) return b;
        if(b == 0) return a;
        return 1;
    }
}
