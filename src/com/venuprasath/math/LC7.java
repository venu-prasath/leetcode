package com.venuprasath.math;

import static com.venuprasath.util.Extension.println;

public class LC7 {

    public static void main(String[] args) {
       int x = 1234567;

       LC7 lc7 = new LC7();
       int result = lc7.reverse(x);
       println(result);
    }

    private int reverse(int x) {
        int num = x;
        int rev = 0;
        while(num != 0) {
            int pop = num % 10;
            num = num/10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }
            rev = rev*10 + pop;
        }
        return rev;
    }
}
