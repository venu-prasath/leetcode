package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class ConvertNumber {

    public static void main(String[] args) {
        int a = 10;
        int b = 7;

        int result = findMinFlips(a, b);
        println(result);
    }

    private static int findMinFlips(int a, int b) {
        int value = a ^ b;
        int count = 0;
        while(value != 0) {
            count++;
            value = value & (value-1);
        }
        return count;
    }
}
