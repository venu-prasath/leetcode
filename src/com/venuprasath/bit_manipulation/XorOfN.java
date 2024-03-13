package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class XorOfN {

    public static void main(String[] args) {
        int n = 24;

        int result = xorOfRange(n);
        println(result);
        int result2 = xorOfRange(4, 7);
        println(result2);
    }

    private static int xorOfRange(int n) {
        if(n % 4 == 0) {
            return 1;
        } else if(n % 4 == 1) {
            return n+1;
        } else if(n % 4 == 2) {
            return 0;
        } else {
            return n;
        }
    }

    private static int xorOfRange(int a, int b) {
        return (xorOfRange(a-1) ^ xorOfRange(b));
    }
}
