package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class SetIthBit {

    public static void main(String[] args) {
        int n = 9;
        int i = 2;

        int value = setIthBit(n, i);
        println(value);
    }

    public static int setIthBit(int n, int i) {
        return ((n | (1<<i)));
    }


}
