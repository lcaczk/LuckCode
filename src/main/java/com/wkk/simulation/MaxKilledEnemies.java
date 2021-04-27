package com.wkk.simulation;

/**
 * @author weikunkun
 * @since 2021/4/27
 */
public class MaxKilledEnemies {
    public int maxKilledEnemies(char[][] grid) {
        // 上下左右搜索每个可放炸弹的位置
        int max = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    // 搜索能炸多少人
                    int nums = getBoomPeople(grid, i, j);
                    max = Math.max(max, nums);
                }
            }
        }
        return max;
    }

    private int getBoomPeople(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        // 行
        int k = 0;
        int leftColIdx = 0;
        int rightColIdx = cols - 1;
        while (k < j) {
            if (grid[i][k] == 'W') {
                leftColIdx = k;
            }
            k++;
        }
        k = cols - 1;
        while (k > j) {
            if (grid[i][k] == 'W') {
                rightColIdx = k;
            }
            k--;
        }
        for (int m = leftColIdx + 1; m < rightColIdx; m++) {
            if (grid[i][m] == 'E') {
                sum++;
            }
        }
        // 列
        k = 0;
        int topRowIdx = 0;
        int bottomRowIdx = rows - 1;
        while (k < i) {
            if (grid[k][j] == 'W') {
                topRowIdx = k;
            }
            k++;
        }
        k = rows - 1;
        while (k > i) {
            if (grid[k][j] == 'W') {
                bottomRowIdx = k;
            }
            k--;
        }

        for (int m = topRowIdx + 1; m < bottomRowIdx; m++) {
            if (grid[k][j] == 'E') {
                sum++;
            }
        }
        return sum;
    }
}
