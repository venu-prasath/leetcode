package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC151 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        LC151 solution = new LC151();
        String result = solution.reverseWords(s);
        println(result);
    }

    private String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        String result = "";
        while(i<n) {
            while(i<n && s.charAt(i) == ' ') i++;
            if(i >= n) break;
            int j = i+1;
            while(j<n && s.charAt(j) != ' ') j++;
            String word = s.substring(i, j);
            if(result.length() == 0) {
                result = word;
            } else {
                result = word + " " + result;
            }
            i = j+1;
        }
        return result;
    }
}
