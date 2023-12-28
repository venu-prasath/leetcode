package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC680 {

    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        LC680 solution = new LC680();
        boolean result = solution.isPalindrome(s);
        println(result);
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
           if(s.charAt(i) != s.charAt(j)) {
               boolean case1 = check(s, i+1, j);
               boolean case2 = check(s, i, j-1);
               if(case1 == true || case2 == true) {
                   return true;
               } else {
                   return false;
               }
           }
           i++;
           j--;
        }
        return true;
    }

    private boolean check(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
