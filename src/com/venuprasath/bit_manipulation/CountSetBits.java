package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 13;
        int count = countSetBits_v2(n);
        println(count);
    }

    private static int countSetBits(int n) {
        int count = 0;
        while(n > 1) {
            count += (n & 1);
            n = n >> 1;
        }
        if(n == 1) count++;
        return count;
    }

    private static int countSetBits_v2(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
