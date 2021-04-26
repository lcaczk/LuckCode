package com.wkk.everyday.two1.april;

/**
 * 矩阵区域不超过k的最大数值和
 * @author weikunkun
 * @since 2021/4/22
 */
public class LC_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //求前缀和
        int[][] prefix = new int[rows + 1][cols + 1];
        for(int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols ; j++) {
                for (int p = i; p <= rows; p++) {
                    for (int q = j; q <= cols; q++) {
                        // (i, j)  (p, q);
                        // prefix[p][q] - prefix[p][j-1] - prefix[i-1][q] + prefix[i-1][j-1];
                        int sum = prefix[p][q] - prefix[p][j-1] - prefix[i-1][q] + prefix[i-1][j-1];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        float a = 0;
        for (int i = 0; i < 10; i++) {
            a += 0.1;
        }
        System.out.println(a);
    }
}
