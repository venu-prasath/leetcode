package com.venuprasath.math.intermediate;

import com.venuprasath.math.basic.CheckForPrime;

import static com.venuprasath.util.Extension.println;

public class PrimeFactors {

    public static void main(String[] args) {
        int n = 780;
        primeFactors(n);
        primeFactors2(n);
    }

    public static void primeFactors2(int n) {
        for(int i = 2; i<= Math.sqrt(n); i++) {
            if(n%i == 0) {
                println(i + "\n");
                while(n%i == 0) {
                    n = n/i;
                }
            }
        }
        if(n != 1) println(n);
    }

    public static void primeFactors(int n) {
        for(int i=1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(CheckForPrime.isPrime(i)) {
                    println(i + "\n");
                    if(n/i == i) {
                        if(CheckForPrime.isPrime(n/i)) {
                            println(n/i + "\n");
                        }
                    }
                }
            }
        }
    }


}
