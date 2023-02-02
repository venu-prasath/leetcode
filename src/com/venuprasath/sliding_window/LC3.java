package com.venuprasath.sliding_window;

import java.util.HashSet;

import static com.venuprasath.util.Extension.print;

public class LC3 {

    public static void main(String[] args) {
        //eg - s = "abcabcbb"
        String s = "pwwkew"; //"abcabcbb";
        LC3 solution = new LC3();
        int result = solution.lengthOfLongestSubstring(s);
        print(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            char[] sChar = s.toCharArray();
            if(!set.contains(sChar[j])) {
                set.add(sChar[j]);
                j++;
                result = Math.max(result, j-i);
            } else {
                set.remove(sChar[i]);
                i++;
            }
        }

        return result;
    }
}
