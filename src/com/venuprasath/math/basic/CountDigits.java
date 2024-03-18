package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class CountDigits {

    public static void main(String[] args) {
        int digit = 2324;
        int res = countDigits(digit);
        println(res);
        res = (int) (Math.log(digit)+1);
        println(res/2);
    }

    public static int countDigits(int n) {
        int count = 0;
        while(n > 0) {
            n = n/10;
            count++;
        }
        return count;
    }
}
