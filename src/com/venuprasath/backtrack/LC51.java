package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC51 {

    public static void main(String[] args) {
        LC51 sol = new LC51();
        sol.nqueens(4);
    }

    public List<List<String>> nqueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        queens(board, 0, res);
        return res;
    }

    private void queens(char[][] board, int row, List<List<String>> res) {
        if(row == board.length) {
            res.add(new ArrayList(construct(board)));
            return;
        }
        for(int col=0; col<board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queens(board, row+1, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        int maxLeft = Math.min(row, col);
        int maxRight = Math.min(row, board.length-1-col);
        for(int i=1; i<=maxLeft; i++) {
            if(board[row-i][col-i] == 'Q') return false;
        }
        for(int i=1; i<=maxRight; i++) {
            if(board[row-i][col+i] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> subList = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            String row = new String(board[i]);
            subList.add(row);
        }
        return subList;
    }
}
