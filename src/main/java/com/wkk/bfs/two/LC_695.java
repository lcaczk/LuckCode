package com.wkk.bfs.two;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/9/12
 */
public class LC_695 {
    private int rows;
    private int cols;
    private int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        // dfs、bfs、并查集
        // bfs
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        int cur = two2one(x, y);
        queue.offer(cur);
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                count++;
                int[] curIdx = one2Two(cur);
                for (int[] step : steps) {
                    int nx = curIdx[0] + step[0];
                    int ny = curIdx[1] + step[1];
                    if (!isPow(nx, ny) || grid[nx][ny] == 0 || visited[nx][ny]) {
                        continue;
                    }
                    queue.offer(two2one(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    private boolean isPow(int x, int y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < cols);
    }

    private int two2one(int x, int y) {
        return x * cols + y;
    }

    private int[] one2Two(int num) {
        return new int[]{num / cols, num % cols};
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{
        0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},{
        0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},{
        0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        LC_695 lc_695 = new LC_695();
        System.out.println(lc_695.maxAreaOfIsland(graph));
    }
}
