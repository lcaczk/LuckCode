package com.wkk.everyday.two1.feb;

/**
 * 867 转置矩阵
 * @author weikunkun
 * @since 2021/2/25
 */
public class LC_867 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
