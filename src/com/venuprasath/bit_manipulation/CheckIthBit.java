package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class CheckIthBit {

    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        boolean checkOne = checkWithLeftShift(n, i);
        boolean checkTwo = checkWithRightShift(n, i);

        println("checkWithLeftShift: " + checkOne);
        println("\ncheckWithRightShfit: " + checkTwo);
    }

    public static boolean checkWithLeftShift(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static boolean checkWithRightShift(int n, int i) {
        return ((n>>i) & 1) == 1;
    }
}
