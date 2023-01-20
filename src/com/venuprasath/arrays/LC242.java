package com.venuprasath.arrays;

import java.util.Arrays;

public class LC242 {

    public static void main(String[] args) {
        Solution_242 solution = new Solution_242();

        String s = "anagram";
        String t = "nagaram";

        boolean answer = solution.isAnagram(s, t);
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
