package com.wkk.backtrack;

/**
 * @Time: 20-4-12上午11:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int start, int i, int j) {
        if (start == word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(start)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = search(board, word, start + 1, i+1 , j) ||
                search(board, word, start +1, i-1, j) ||
                search(board, word, start +1, i, j+1) ||
                search(board, word, start +1, i, j-1);

        board[i][j] = c;
        return res;
    }
}
