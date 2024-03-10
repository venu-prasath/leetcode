package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class Check2Power {

    public static void main(String[] args) {
        int n = 16;
        boolean result = check(n);
        println(result);
    }

    private static boolean check(int n) {
        return (n & (n-1)) == 0;
    }
}
