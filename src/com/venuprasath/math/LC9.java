package com.venuprasath.math;

import static com.venuprasath.util.Extension.println;

public class LC9 {

    public static void main(String[] args) {
        int x = 123212;
        LC9 sol = new LC9();
        boolean result = sol.isPalindrome(x);
        println(result);
    }

    public boolean isPalindrome(int x) {
        int rev = reverse(x);
        if (rev < 0) return false;
        if(x == rev) {
            return true;
        }
        return false;
    }

    int reverse(int x) {
        int num = x;
        int result = 0;

        while(num != 0) {
            int pop = num % 10;
            num = num/10;
            if(result > Integer.MAX_VALUE || result == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if(result < Integer.MIN_VALUE || result == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
