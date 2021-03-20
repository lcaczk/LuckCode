package com.wkk.bytedance2021.dp;

/**
 * 64 最小路径和
 * 动归经典
 * 1. 找动态转移方程
 * 2. 优化 压缩数组
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_64 {
    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 动归
        // 从后向前，每次选取最小的
        int row = grid.length;
        int col = grid[0].length;
        int more = Math.max(row, col);
        int less = Math.min(row, col);
        boolean rowMore = more == row;
        int[] res = new int[less];
        int cur = 0;
        res[0] = grid[0][0];
        for (int i = 1; i < less; i++) {
            cur = rowMore ? grid[0][i] : grid[i][0];
            res[i] = res[i-1] + cur;
        }
        for (int i = 1; i < more; i++) {
            cur = rowMore ? grid[i][0] : grid[0][i];
            res[0] = res[0] + cur;
            for (int j = 1; j < less; j++) {
                cur = rowMore ? grid[i][j] : grid[j][i];
                res[j] = Math.min(res[j], res[j-1]) + cur;
            }
        }
        return res[less-1];
    }
}
