package com.venuprasath.sliding_window;

import static com.venuprasath.util.Extension.print;


/*
*   Wrong Solution. This is a solution if a s2 contains a palindrome of s1 as a substring.
*   Not the solution for LC567
 */
public class LC567 {

    public static void main(String[] args) {
        //eg - s1 = "ab", s2 = "eidbaooo"
        String s1 = "abc";
        String s2 = "bbbca";
        LC567 solution = new LC567();
        boolean result = solution.checkInclusion(s1, s2);
        print(result);
    }

    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        int i = 0;
        int j = s2.length()-1;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        while(j >= 0 && i < s1.length()) {
            if(s2Chars[j] != s1Chars[i]) {
                if(result == true) {
                    i--;
                }
                j--;
                result = false;
                continue;
            }
            else {
                result = true;
                j--;
                i++;
            }
        }
        return result;
    }
}
