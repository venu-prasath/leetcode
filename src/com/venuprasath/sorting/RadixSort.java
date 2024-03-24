package com.venuprasath.sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
        radixSort(arr, n);
        print(arr, n);
    }

    public static void print(int[] arr, int n) {
        for(int num: arr) {
            System.out.println(num + " ");
        }
        System.out.println("\n");
    }

    public static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(i=0; i<n; i++) {
            count[(arr[i]/exp)%10]++;
        }

        for(i=1; i<10; i++) {
            count[i] += count[i-1];
        }

        for(i=n-1; i>=0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(i=0; i<n; i++) {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr, int n) {
        if(n < 1) return;
        int largest = getMax(arr, n);

        for(int exp=1; largest/exp > 0; exp*=10) {
            countSort(arr, n, exp);
        }
    }

    public static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for(int i = 1; i<n; i++) {
            if(arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }
}
