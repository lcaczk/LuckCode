package com.wkk.bytedance2021.binarysearch;

/**
 * 240. 搜索二维矩阵 II
 * 思路 二分查找
 * @author weikunkun
 * @since 2021/4/7
 */
public class LC_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路 从左下角开始
        int row = matrix.length -1;
        int col = 0;
        int cols = matrix[0].length;
        while (row >= 0 && col < cols) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
