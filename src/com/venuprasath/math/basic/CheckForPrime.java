package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class CheckForPrime {

    public static void main(String[] args) {
        println(isPrime(13));
        println(isPrime(24));
        println(isPrime(31));
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for(int i=1; i<= Math.sqrt(n); i++) {
            if(n%i == 0) {
                count++;
            }
        }
        return count == 1;
    }
}
