package com.venuprasath.dp;

import static com.venuprasath.util.Extension.println;

public class LC931 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int minSum = minFallingPathSum(matrix);
        println(minSum);
    }

    private static int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];

        for(int col=0; col<matrix.length; col++) {
            minSum = Math.min(minSum, findMinSum(matrix, 0, col, memo));
        }

        return minSum;
    }

    private static int findMinSum(int[][] matrix, int row, int col, Integer[][] memo) {
        if(col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        if(row == matrix.length-1) {
            return matrix[row][col];
        }
        if(memo[row][col] != null) {
            return memo[row][col];
        }
        int left = findMinSum(matrix, row+1, col-1, memo);
        int middle = findMinSum(matrix, row+1, col, memo);
        int right = findMinSum(matrix, row+1, col+1, memo);

        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];

        return memo[row][col];
    }
}
