package com.venuprasath.math.intermediate;

public class PrimeFactorization {

    public static void main(String[] args) {
        int[] spf = getSpf(60);

    }

    public static int[] getSpf(int n) {
        int[] spf = new int[n+1];
        for(int i=1; i <= n; i++) spf[i] = i;

        for(int i=2; i*i <= n; i++) {
            if(spf[i] == i) {
                for(int j=i*i; j<= n; j+= i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
}
