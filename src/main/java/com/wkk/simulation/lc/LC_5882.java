package com.wkk.simulation.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/9/26
 */
public class LC_5882 {
    int rows;
    int cols;

    public long gridGame(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Map<Integer, int[]> map = new HashMap<>();

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            int idx = two2one(i, 0);
            map.put(idx, new int[]{i - 1, 0});
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            int idx = two2one(0, i);
            map.put(idx, new int[]{0, i - 1});
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int idx = two2one(i, j);
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    map.put(idx, new int[]{i - 1, j});
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    map.put(idx, new int[]{i, j - 1});
                }
            }
        }

        int[] cur = {rows - 1, cols - 1};
        int idx = two2one(rows - 1, cols - 1);
        while (cur[0] != 0 || cur[1] != 0) {
            cur = map.get(idx);
            grid[cur[0]][cur[1]] = 0;
            idx = two2one(cur[0], cur[1]);
        }
        grid[0][0] = 0;
        grid[rows - 1][cols - 1] = 0;

        int[][] f = new int[rows][cols];
        f[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            f[0][i] = grid[0][i] + f[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[rows - 1][cols - 1];
    }

    private int two2one(int i, int j) {
        return i * cols + j;
    }

    private int[] one2two(int x) {
        int i = x / cols;
        int j = x % cols;
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        LC_5882 lc_5882 = new LC_5882();
        System.out.println(lc_5882.gridGame(matrix));
    }
}
