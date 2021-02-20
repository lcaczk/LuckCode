package com.wkk.top100.array.medium;

/**
 * 64 最小路径和
 * 二位数组的动态规划
 * @author weikunkun
 * @since 2021/2/19
 */
public class LC_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || null == grid || grid[0].length == 0) {
            return 0;
        }
        // 动归
        // 从后向前，每次选取最小的
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 2; i >= 0; i--) {
            grid[i][n - 1] = grid[i + 1][n - 1] + grid[i][n - 1];
        }

        for (int j = n - 2; j >= 0; j--) {
            grid[m - 1][j] = grid[m - 1][j + 1] + grid[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];

    }

    public static void main(String[] args) {
        int[][] array = {{1,3,1}, {1,5,1}, {4,2,1}};
        LC_64 lc_64 = new LC_64();
        lc_64.minPathSum(array);
    }

}
