package com.venuprasath.sorting;

import static com.venuprasath.util.Extension.println;

public class InsertionSort {

    public static void main(String[] args) {

        println("Insertion Sort\n");
        InsertionSort selection = new InsertionSort();
        int[] items = {5, 4, 3, 2, 1 };
        for (int sortedItem : items) {
            println(sortedItem);
        }
        println("\n");
        int[] sorted_items = selection.sort(items);
        for (int sortedItem : sorted_items) {
            println(sortedItem);
        }
    }

    private int[] sort(int[] items) {
        for(int i=1; i<items.length; i++) {
            for(int j=0; j<=i; j++) {
                if(items[i] < items[j]) {
                    int temp = items[j];
                    items[j] = items[i];
                    items[i] = temp;
                }
            }
        }
        return items;
    }
}
