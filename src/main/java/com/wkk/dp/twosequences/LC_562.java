package com.wkk.dp.twosequences;

/**
 * @author weikunkun
 * @since 2021/7/15
 */
public class LC_562 {
    public static int longestLine(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        // 三角模型 （双序列模型）
        int[][] dp = new int[rows][cols];
        // 在 i, j  位置时 最长的连续1的长度
        // 4个方向 dp[i - 1][j], dp[i][j - 1], dp[i - 1][j + 1], dp[i - 1][j - 1]
        // 初始化
        dp[0][0] = mat[0][0] == 1 ? 1 : 0;
        int max = 0;
        for (int i = 1; i < rows; i++) {
            if (mat[i][0] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                max = Math.max(dp[i][0], max);
            }
        }

        for (int j = 1; j < cols; j++) {
            if (mat[0][j] == 1) {
                dp[0][j] = dp[0][j - 1] + 1;
                max = Math.max(dp[0][j], max);
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 1) {
                    if (j == cols - 1) {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                        max = Math.max(max, dp[i][j]);
                    } else {
                        int diagonal = Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                        int rowCol = Math.max(dp[i][j - 1], dp[i - 1][j]);
                        dp[i][j] = Math.max(diagonal, rowCol);
                        max = Math.max(dp[i][j], max);
                    }

                }
            }
        }
        return max;
    }

    void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
