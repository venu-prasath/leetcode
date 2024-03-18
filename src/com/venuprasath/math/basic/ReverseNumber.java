package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class ReverseNumber {

    public static void main(String[] args) {
        int n = 7789;
        int res = reverse(n);
        println(res);
    }

    public static int reverse(int n) {
        int reversed = 0;

        while(n > 0) {
            int lastNum = n%10;
            n = n/10;
            reversed = reversed*10 + lastNum;
        }
        return reversed;
    }
}
