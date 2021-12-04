package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_48 {
    public void rotate(int[][] matrix) {
        // 顺时针
        // 先对角 在左右
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = tmp;
            }
        }
    }
}
