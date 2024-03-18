package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class CheckPalindrome {

    public static void main(String[] args) {
        int n = 1331;
        boolean palindrome = checkPalindrome(n);
        println(palindrome);
    }

    public static boolean checkPalindrome(int n ) {
       int duplicate = ReverseNumber.reverse(n);
       return duplicate == n;
    }


}
