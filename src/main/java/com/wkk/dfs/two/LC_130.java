package com.wkk.dfs.two;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class LC_130 {
    char FLAG = '#';
    int rows;
    int cols;
    int[][] steps = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    boolean[][] vistied;
    public void solve(char[][] board) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return;
        }
        rows = board.length;
        cols = board[0].length;
        vistied = new boolean[rows][cols];
        // 正向思路
        // 把所有符合要求的点，修改
        // 再把和边链接的所有点修改回来

        // 逆向思路
        // 找到 和边的点相邻的要求点 标记 其余要求点修改
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);
            dfs(i, cols - 1, board);
        }

        for (int i = 0; i < cols; i++) {
            dfs(0, i, board);
            dfs(rows - 1, i, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == FLAG) {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (!isPos(i, j) || vistied[i][j] || board[i][j] != 'O') {
            return;
        }
        board[i][j] = FLAG;
        for (int[] step : steps) {
            int nX = i + step[0];
            int nY = j + step[1];
            dfs(nX, nY, board);
        }
    }

    private boolean isPos(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }
}
