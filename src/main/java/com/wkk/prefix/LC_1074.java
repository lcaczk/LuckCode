package com.wkk.prefix;

/**
 * @author weikunkun
 * @since 2021/5/29
 */
public class LC_1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // 二维数组的前缀和
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] preSum = new int[rows+1][cols+1];
        // 构建前缀数组
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                preSum[i][j] = matrix[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
            }
        }

        int count = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                for (int m = 1; m <= i; m++) {
                    for (int n = 1; n <= j; n++) {
                        int cur = preSum[i][j] - preSum[m-1][j] - preSum[i][n-1] + preSum[m-1][n-1];
                        if (cur == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
