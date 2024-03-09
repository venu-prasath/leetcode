package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class Int2Binary {

    public static void main(String[] args) {
        int n = 13;
        String result = string2Binary(n);
        println("Result:\n");
        println(result);
    }

    public static String string2Binary(int n) {
        StringBuilder result= new StringBuilder();

        while(n != 1) {
            if(n%2 == 1) {
                result.insert(0, "1");
            } else {
                result.insert(0, "0");
            }
            n = n/2;
        }
        result.insert(0, "1");
        return result.toString();
    }
}
