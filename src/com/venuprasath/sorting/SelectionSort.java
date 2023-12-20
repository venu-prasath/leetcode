package com.venuprasath.sorting;

import static com.venuprasath.util.Extension.println;

public class SelectionSort {

    public static void main(String[] args) {

        println("Selection Sort\n");
        SelectionSort selection = new SelectionSort();
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
        for(int i=0; i<items.length-1; i++) {
            int min = i;
            for(int j=i; j<items.length; j++) {
                if(items[j] < items[min]) min = j;
            }
            int temp = items[i];
            items[i] = items[min];
            items[min] = temp;
        }
        return items;
    }
}
