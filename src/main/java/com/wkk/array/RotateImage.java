package com.wkk.array;

/**
 * @author kongwiki@163.com
 * @since 2020/8/11下午9:52
 */
public class RotateImage {

    /**
     * 本质是对四个位置的元素进行交换
     * 任意一个(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)就是这四个索引号上的数交换.
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    /**
     * 先整体反转数组 之后再对角反转
     * [                    [                  [
     * [1,2,3],             [7,8,9],            [7,4,1],
     * [4,5,6],    ---->    [4,5,6], ----->     [8,5,2],
     * [7,8,9]              [1,2,3]             [9,6,3]
     * ]                    ]
     *
     * @param matrix 矩阵
     */
    public void rotateII(int[][] matrix) {
        // 1 整体反转
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        // 对角反转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
