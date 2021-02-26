package com.offer;

/**
 * 题目：剑指 Offer 04.二维数组中的查找
 * 题目链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 标签：数组 双指针
 * <p>
 * 题目描述：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * <p>
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 判空 [[]] 条件也需要考虑， 所以需要外加一个判断 matrix[0].length == 0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 每一行最左边是最小的，每一列最上边是最小的
        // 从左下角开始遍历，如果大于目标值向上一行，如果小于目标值向右一列
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}