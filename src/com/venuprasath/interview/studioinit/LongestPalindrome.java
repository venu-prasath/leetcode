package com.venuprasath.interview.studioinit;

public class LongestPalindrome {

    public static void main(String[] args) {
        //given a string print the longest Palindromic substring found in the string.
        //if not palindrome is found, return "none"

        Solution solution = new Solution();
        String answer = solution.findPalindrome("asdaabbaaasd");
        System.out.println(answer);

    }

    public static class Solution {

        public Solution() {

        }

        public String findPalindrome(String s) {
            return s;
        }
    }


}

