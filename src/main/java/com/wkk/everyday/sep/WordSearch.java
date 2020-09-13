package com.wkk.everyday.sep;

/**
 * 题目：单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * <p>
 * 思路： 回溯。。。
 * @author kongwiki@163.com
 * @since 2020/9/13 9:18 上午
 */
public class WordSearch {
    // 铁定是回溯月了， 前几天是一维的问题，现在是而为问题
    public boolean exist(char[][] board, String word) {
        int cols = board[0].length;
        int rows = board.length;
        if(board == null || cols == 0 || rows == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return false;
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int start){
        // 先判断越界或者不符合的错误条件
        int rows = board.length;
        int cols = board[0].length;
        if(start == word.length()){
            return true;
        }
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] !=  word.charAt(start)){
            return false;
        }
        char ch = board[row][col];
        board[row][col] = ' ';
        boolean res = backtrack(board, word, row+1, col, start+1)
                || backtrack(board, word, row-1, col, start+1)
                || backtrack(board, word, row, col +1 , start+1)
                || backtrack(board, word, row, col - 1, start+1);
        board[row][col] = ch;
        return res;
    }
}
