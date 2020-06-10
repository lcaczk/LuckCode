package com.wkk.dp;

/**
 * @Time: 2020/6/10上午10:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        assert grid != null;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j]+dp[i][j-1];
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] b = {{}};
        int i = minPathSum(b);
        System.out.println(i);
    }
}
