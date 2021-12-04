package com.wkk.interview.bytedance2021.array;

import java.util.Objects;

/**
 * 48 图像翻转
 *
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_48 {
    /**
     * 该思路同理可放入以为数组
     * [1,2,3,4,5,6,7,8]
     * 翻转前k个元素到末尾
     * 先将前k个原地翻转
     * 在将n-k个原地翻转
     * 最后n个一起翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 思路：
        // 先行翻转
        // 再对角翻转
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 行翻转
        for (int i = 0; i < row / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[row - i - 1];
            matrix[row - i - 1] = temp;
        }

        // 对角翻转
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

}
