package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class FindDifference {

    public static void main(String[] args) {
        String str1 = "aabd";
        String str2 = "aabde";

        int idx = findDifference(str1, str2);
        println(idx);
    }

    public static int findDifference(String str1, String str2) {
        int result = 0;
        int l1 = str1.length();
        int l2 = str2.length();

        for(int i=0; i<l1; i++) {
            result ^= str1.charAt(i);
        }
        for(int i=0; i<l2; i++) {
            result ^= str2.charAt(i);
        }

        if(l1 > l2) {
            return str1.indexOf((char) result);
        } else {
            return str2.indexOf((char) result);
        }
    }
}
