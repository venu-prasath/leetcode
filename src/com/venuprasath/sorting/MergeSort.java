package com.venuprasath.sorting;

import java.util.ArrayList;

public class MergeSort {

    public static void main(String args[]) {
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before MergeSort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        new MergeSort().mergeSort(arr, 0, n - 1);
        System.out.println("After MergeSort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right  <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i=low; i<=high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
