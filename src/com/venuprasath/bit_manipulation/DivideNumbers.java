package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class DivideNumbers {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        int result = divide(dividend, divisor);
        println(result);
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean positive = true;
        if(dividend >= 0 && divisor < 0) positive = false;
        if(dividend < 0 && divisor >= 0) positive = false;

        long n = Math.abs(dividend);
        long d = Math.abs(divisor);

        long ans = 0;

        while(n >= d) {
            int count = 0;
            while(n >= d << (count+1)) { // d * 2^(count+1)
                count++;
            }
            ans += 1 << count; // 2^count
            n = n - (d * (1 << count));
        }
        if( ans >= (2^31) && positive) return Integer.MAX_VALUE;
        if(ans >= (2^31) && !positive) return Integer.MIN_VALUE;
        else {
            if(positive) return (int) ans;
            else return (int) (-1 * ans);
        }
    }
}
