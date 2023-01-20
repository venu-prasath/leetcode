package com.venuprasath.arrays;

import java.util.Arrays;

public class LC242 {

    public static void main(String[] args) {
        Solution_242 solution = new Solution_242();

        String s = "anagram";
        String t = "nagaram";

        boolean answer = solution.isAnagram(s, t);
        System.out.println(answer);

        Solution2_LC242 sol2 = new Solution2_LC242();
        sol2.isAnagram(s,t);
        answer = solution.isAnagram(s, t);
        System.out.println(answer);

    }

}

class Solution_242 {
    public boolean isAnagram(String s, String t) {
        char[] sTemp = s.toCharArray();
        char[] tTemp = t.toCharArray();
        Arrays.sort(sTemp);
        Arrays.sort(tTemp);
        int i = 0;
        int j = 0;

        if(sTemp.length != tTemp.length) return false;
        while(i < sTemp.length && j < tTemp.length)  {
            if(sTemp[i] != tTemp[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}

class Solution2_LC242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for(int i=0; i<s.length(); i++) {
            sArray[((int)s.charAt(i)) - 97]++;
        }
        for(int i=0; i<t.length(); i++) {
            tArray[((int)t.charAt(i)) - 97]++;
        }

        for(int i=0; i<26; i++) {
            if(sArray[i] != tArray[i]) return false;
        }

        return true;
    }
}
