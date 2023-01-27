package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC74 {

    public static void main(String[] args) {
        //eg - [1,3,5,7],[10,11,16,20],[23,30,34,60]]
        int[][] matrix = new int[][] {{1, 3, 5, 7 }, {10, 11, 16, 20 }, {23, 30, 34, 60 }};
        LC74 solution = new LC74();
        boolean result = solution.searchMatrix(matrix, 3);
        print(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        int m = matrix.length;
        int n = matrix[0].length;
        int first = 0;
        int last = (m*n) - 1;

        while(first <= last) {
            int mid = (first + (last - first)/2);
            if(matrix[mid/n][mid%n] == target) {
                return true;
            } else if(matrix[mid/n][mid%n] > target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return result;
    }
}
