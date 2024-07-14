package com.venuprasath.math.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class CountPrimesInRange {

    public static void main(String[] args) {
        int l = 3;
        int r = 10;
        int n = 100;
        int[] primes = getSeive(n);
        int count = 0;

        for(int i=2; i<=n; i++) {
            count = count + primes[i];
            primes[i] = count;
        }
        println(primes[r] - primes[l-1]);

    }



    public static int[] getSeive(int n) {
        int[] prime = new int[n+1];
        for(int i=2; i<=n; i++) prime[i] = 1;

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(prime[i] == 1) {
                for(int j=i*i; j<= n; j+=i) {
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }
}
