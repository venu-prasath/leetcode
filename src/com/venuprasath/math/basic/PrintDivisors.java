package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class PrintDivisors {

    public static void main(String[] args) {
        divisors(36);
    }

    public static void divisors(int n) {
        for(int i=1; i*i <= n; i++) {
            if (n % i == 0) {
                println(i + "\n");
                if(n/i != i) {
                    println((n/i) + "\n");
                }
            }
        }
    }
}
