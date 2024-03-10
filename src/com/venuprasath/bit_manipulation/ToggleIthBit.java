package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class ToggleIthBit {

    public static void main(String[] args) {
        int n = 13;
        int i = 1;

        int value = toggle(n, i);
        println(value);
    }

    private static int toggle(int n, int i) {
        return (n ^ (1<<i));
    }
}
