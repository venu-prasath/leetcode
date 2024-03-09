package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class Binary2Int {

    public static void main(String[] args) {
        String input = "1101";
        int result = string2Int(input);
        println(result);
    }

    private static int string2Int(String input) {
        int p2 = 1;
        int result = 0;
        for(int i=input.length()-1; i>=0; i--) {
            if(input.charAt(i) == '1') {
                result += p2;
            }
            p2 *= 2;
        }
        return result;
    }
}
