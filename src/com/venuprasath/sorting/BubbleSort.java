package com.venuprasath.sorting;

import static com.venuprasath.util.Extension.println;

public class BubbleSort {

    public static void main(String[] args) {

        println("Bubble Sort\n");
        BubbleSort bubbleSort = new BubbleSort();
        int[] items = {5, 4, 3, 2, 1 };
        for (int sortedItem : items) {
            println(sortedItem);
        }
        println("\n");
        int[] sorted_items = bubbleSort.sort(items);
        for (int sortedItem : sorted_items) {
            println(sortedItem);
        }
    }

    private int[] sort(int[] items) {
        for(int j=0; j<items.length; j++) {
            for(int i=0; i<items.length-1; i++) {
                if(items[i+1]<items[i]) {
                    int temp = items[i+1];
                    items[i+1] = items[i];
                    items[i] = temp;
                }
            }
        }
        return items;
    }
}
