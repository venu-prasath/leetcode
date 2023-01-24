package com.venuprasath.arrays;

import java.util.HashSet;
import java.util.Set;

import static com.venuprasath.util.Extension.print;

public class LC36 {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        LC36 solution = new LC36();
        boolean result = solution.isValidSudoku(board);
        print(result);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] sub = new HashSet[9];

        for(int i = 0; i< 9; i++) {
            row[i] = new HashSet();
            col[i] = new HashSet();
            sub[i] = new HashSet();
        }

        for(int i = 0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') continue;
                int subIndex = (i/3)*3 + j/3;
                if(row[i].contains(board[i][j]) || col[j].contains(board[i][j]) ||
                        sub[subIndex].contains(board[i][j])) {
                    return false;
                }
                row[i].add(board[i][j]);
                col[j].add(board[i][j]);
                sub[subIndex].add(board[i][j]);
            }
        }
        return true;
    }
}
