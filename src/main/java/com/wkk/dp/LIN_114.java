package com.wkk.dp;

/**
 * 有一个机器人的位于一个 m × n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 问有多少条不同的路径？
 * @author weikunkun
 * @since 2021/3/11
 */
public class LIN_114 {
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
