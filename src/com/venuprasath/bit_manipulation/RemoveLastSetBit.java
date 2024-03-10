package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class RemoveLastSetBit {

    public static void main(String[] args) {
        int n = 16;
        int value = removeLast(n);
        println(value);
    }

    private static int removeLast(int n) {
        return n & (n-1);
    }
}
