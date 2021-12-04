package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class LC_200 {
    private int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    int[] arr;
                    count++;
                    while (!queue.isEmpty()) {
                        arr = queue.poll();
                        for (int[] step : steps) {
                            int first = arr[0] + step[0];
                            int second = arr[1] + step[1];
                            if (isPow(first, second) && !visited[first][second]) {
                                visited[first][second] = true;
                                queue.offer(new int[]{first, second});
                            }
                        }
                    }
                }
            }
        }
        return  count;
    }

    private boolean isPow(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }
}
