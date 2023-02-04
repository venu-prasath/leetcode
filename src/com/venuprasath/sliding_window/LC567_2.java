package com.venuprasath.sliding_window;

import java.util.HashSet;

import static com.venuprasath.util.Extension.print;

public class LC567_2 {

    HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        //eg - s1 = "ab", s2 = "eidbaooo"
        String s1 = "ab";
        String s2 = "eidbaooo";

        LC567_2 solution = new LC567_2();
        boolean result = solution.checkInclusion(s1, s2);
        print(result);
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] arr = new int[26];

        for(int i=0; i<s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        int i=0;
        int j=0;
        for(; j < s1.length(); j++) {
            arr[s2.charAt(j) - 'a']--;
        }
        j--;
        if(isEmpty(arr)) return true;

        while (j < s2.length()) {
            arr[s2.charAt(i) - 'a']++;
            i++;
            j++;
            if (j < s2.length()) arr[s2.charAt(j) - 'a']--;
            if (isEmpty(arr)) return true;
        }
        return isEmpty(arr);
    }

    public boolean isEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
