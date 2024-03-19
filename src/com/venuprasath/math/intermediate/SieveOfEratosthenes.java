package com.venuprasath.math.intermediate;

import static com.venuprasath.util.Extension.println;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        blackBox(30);
    }

    public static void blackBox(int n) {
        int[] prime = new int[n+1];
        for(int i = 2; i<=n; i++) prime[i-2] = 1;

        for(int i=2; i<Math.sqrt(n); i++) {
            if(prime[i] == 1) {
                for(int j = i*i; j <= n; j+= i) {
                    prime[j] = 0;
                }
            }
        }

        for(int i = 2; i<=n; i++) {
            if(prime[i] == 1) println(i+"\n");
        }
    }
}
