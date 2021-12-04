package com.wkk.simulation.wy;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class D {
    private static int NF = Integer.MAX_VALUE - 8;
    private static int NONE = 2;

    public static int minSailCost(int[][] input) {
        // write code here
        int rows = input.length;
        int cols = input[0].length;
        int[][] dp = new int[rows][cols];
        if (input[0][0] == 0) {
            dp[0][0] = 2;
        } else if (input[0][0] == 1) {
            dp[0][0] = 1;
        } else {
            return -1;
        }
        for (int i = 1; i < rows; i++) {
            if (input[i][0] == NONE) {
                dp[i][0] = NF;
            } else {
                int cur = input[i][0] == 1 ? 1 : 2;
                dp[i][0] = dp[i - 1][0] + cur;
            }
        }

        for (int i = 1; i < cols; i++) {
            if (input[0][i] == NONE) {
                dp[0][i] = NF;
            } else {
                int cur = input[0][i] == 1 ? 1 : 2;
                dp[0][i] = dp[0][i - 1] + cur;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (input[i][j] == NONE) {
                    dp[i][j] = NF;
                } else {
                    int cur = input[i][j] == 1 ? 1 : 2;
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cur;
                }
            }
        }
        printMatrix(dp);
        return dp[rows - 1][cols - 1] == NF ? -1 : dp[rows - 1][cols - 1] - dp[0][0];
    }

    private static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {1, 1, 2, 1, 1}, {0, 2, 0, 0, 1}};
        minSailCost(matrix);
    }
}
