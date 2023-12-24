package com.venuprasath.arrays;

import static com.venuprasath.util.Extension.println;

public class LC283 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 34, 4, 0, 1, 2, 3, 4};
        LC283 sol = new LC283();
        sol.moveZeros(arr);
        for(int i=0; i<arr.length; i++) {
            println(arr[i]);
        }
    }

    private void moveZeros(int[] arr) {
        int j = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;

        for(int i=j+1; i<arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return;
    }
}
