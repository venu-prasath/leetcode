package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class ClearIthBit {

    public static void main(String[] args) {
        int n = 13;
        int i = 2;

        int value = clearIthBit(n, i);
        println(value);
    }

    public static int clearIthBit(int n, int i) {
        return (n & ~(1 << i));
    }

}
