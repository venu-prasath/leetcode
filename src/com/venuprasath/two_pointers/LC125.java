package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.print;

public class LC125 {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";

        LC125 solution = new LC125();
        boolean result = solution.isPalindrome(input);
        print(result);
    }

    public boolean isPalindrome(String s) {
        boolean result = true;

        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            String str1 = String.valueOf(s.charAt(i));
            if(isAlphaNumeric(str1)) {
                String str2 = String.valueOf(s.charAt(j));
                if(isAlphaNumeric(str2)) {
                    print(str1);
                    print(str2);
                    if(!str1.toLowerCase().equals(str2.toLowerCase())) {
                        return false;
                    }
                } else {
                    j--;
                    continue;
                }
                j--;
            }
            i++;
        }
        return result;
    }

    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
}
