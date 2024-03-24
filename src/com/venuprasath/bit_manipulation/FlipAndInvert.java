package com.venuprasath.bit_manipulation;

import static com.venuprasath.util.Extension.println;

public class FlipAndInvert {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] result = flipAndInvert(image);
        for(int[] row: result) {
            for(int col: row) {
                println(col + "\t");
            }
        }
    }

    public static int[][] flipAndInvert(int[][] image) {
        int rowLength = image.length;
        int mid = (rowLength + 1)/2;

        for(int[] row: image) {
            for(int i=0; i<mid; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[rowLength - 1 - i] ^ 1;
                row[rowLength - 1 - i] = temp;
            }
        }
        return image;
    }
}
