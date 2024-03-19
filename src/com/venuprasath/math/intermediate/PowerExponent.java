package com.venuprasath.math.intermediate;

import static com.venuprasath.util.Extension.println;

public class PowerExponent {

    public static void main(String[] args) {
        int x = 2;
        int n = 21;
        println(pow(x, n));
    }

    public static int pow(int x, int n) {
        int ans = 1;
        boolean isNegative = n < 0;

        while(n > 0) {
            if(n%2 == 1) {
                ans = ans * x;
                n = n-1;
            } else {
                n = n/2;
                x = x*x;
            }
        }
        if(isNegative) return (1/ans);
        return ans;
    }
}
