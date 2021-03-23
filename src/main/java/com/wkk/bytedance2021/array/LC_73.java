package com.wkk.bytedance2021.array;

/**
 * @author weikunkun
 * @since 2021/3/24
 */
public class LC_73 {
    private static final int FLAG = 0;
    private static final boolean REPLACE = true;
    private static int rows;
    private static int cols;
    public void setZeroes(int[][] matrix) {
        // 先寻找 为0的元素，然后对应位置行列置为true
        // 最后将特殊符号置为0即可
        if (null == matrix || matrix.length == 0) {
            return;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == FLAG) {
                    setColAndRowRepalce(flag, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 置 0
                if (flag[i][j] == REPLACE) {
                    setColAndRowOne(matrix, i, j);
                }
            }
        }
    }

    private void setColAndRowRepalce(boolean[][] matrix, int row, int col) {
        for (int i = 0; i < cols; i++) {
            matrix[row][i] = true;
        }

        for (int j = 0; j < rows; j++) {
            matrix[j][col] = true;
        }
    }

    private void setColAndRowOne(int[][] matrix, int row, int col) {
        matrix[row][col] = FLAG;
    }

    public static void main(String[] args) {
        LC_73 lc_73 = new LC_73();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        lc_73.setZeroes(matrix1);

    }
}
