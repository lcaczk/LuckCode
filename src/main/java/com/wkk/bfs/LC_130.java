package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class LC_130 {
    int rows;
    int cols;
    int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    char FLAG = '#';
    boolean[][] visited;

    public void solve(char[][] board) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return;
        }
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            bfs(board, i, 0);
            bfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            bfs(board, 0, j);
            bfs(board, rows - 1, j);

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

    private void bfs(char[][] board, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] step : steps) {
                    int nX = cur[0] + step[0];
                    int nY = cur[1] + step[1];
                    if (isPow(nX, nY) && !visited[nX][nY] && board[nX][nY] == 'O') {
                        board[nX][nY] = FLAG;
                        queue.offer(new int[]{nX, nY});
                    }
                }
            }
        }
    }

    private boolean isPow(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }
}
