package com.wkk.dfs;

/**
 * @Time: 20-3-24上午9:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SurroundedRegions {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final char L = 'o', W = 'x';

    public void solve(char[][] board) {

    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return;
        }
        if(board[x][y] == L){

        }

    }
}
