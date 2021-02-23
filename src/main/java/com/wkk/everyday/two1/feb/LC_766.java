package com.wkk.everyday.two1.feb;

/**
 * 766 托普利茨矩阵
 * 1. 思路 详见注释
 * @author weikunkun
 * @since 2021/2/22
 */
public class LC_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //步骤
        // 1. 先定位好行列首位数字
        // 2. 对比斜线数字是否相同
        // 1. 首行
        for (int i = 0; i < col; i++) {
            int cur = matrix[0][i];
            for(int j = 1, k = 1; j < row && i+k < col; j++, k++) {
                if (matrix[j][i+k] != cur) {
                    return false;
                }
            }
        }
        // 2. 首列
        for (int i = 0; i < row; i++) {
            int cur = matrix[i][0];
            for(int j = 1, k = 1; j + i < row && k < col; j++, k++) {
                if (matrix[i+j][k] != cur) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 时间复杂度为O(n^2)
     * 空间复杂度为O(1)
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrixII(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row-1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
