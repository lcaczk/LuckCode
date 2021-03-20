package com.wkk.bytedance2021.string;

/**
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_79 {
    private int rows;
    private int cols;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (patternWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean patternWord(char[][] board, int row, int col, String word, int starter) {
        if (starter == word.length()) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols || word.charAt(starter)!= board[row][col] ) {
            return false;
        }
        char ch = board[row][col];
        board[row][col] = '#';
        boolean result = patternWord(board, row + 1, col, word, starter + 1)
                || patternWord(board, row, col + 1, word, starter + 1)
                || patternWord(board, row - 1, col, word, starter + 1)
                || patternWord(board, row, col - 1, word, starter + 1);
        board[row][col] = ch;
        return result;
    }

    public static void main(String[] args) {
        LC_79 lc_79 = new LC_79();
    }
}
