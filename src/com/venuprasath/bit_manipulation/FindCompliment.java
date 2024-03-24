package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class FindCompliment {

    public static void main(String[] args) {
        int n = 13;
        int ans = complement(n);
        println(ans);
    }

    public static int complement(int n) {
        int bitLength = (int)Math.floor((int)(Math.log(n)/Math.log(2))) + 1;
        int bitMask = (1 << bitLength) - 1;
        return n ^ bitMask;
    }
}
