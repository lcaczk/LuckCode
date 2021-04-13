package com.wkk.bytedance2021.dp;

/**
 * 221. 最大正方形
 * @author weikunkun
 * @since 2021/4/13
 */
public class LC_221 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        // dp[i][j] (i,j)为右下角是，能够成最大的边长
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = Math.max(dp[i][0], max);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = Math.max(dp[0][i], max);
            }

        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int temp = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(temp, dp[i-1][j-1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;

    }

    public static void main(String[] args) {
    }
}
