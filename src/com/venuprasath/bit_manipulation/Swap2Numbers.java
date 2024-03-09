package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class Swap2Numbers {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        println("a = " + a + "\n");
        println("b = " + b + "\n");

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        println("a = " + a + "\n");
        println("b = " + b + "\n");
    }
}
