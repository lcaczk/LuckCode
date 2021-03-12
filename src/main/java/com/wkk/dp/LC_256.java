package com.wkk.dp;

/**
 * 256 粉刷房子
 *
 * @author weikunkun
 * @since 2021/3/12
 */
public class LC_256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[][] f = new int[n + 1][3];
        f[0][0] = f[0][1] = f[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][k] + costs[i - 1][j]);
                    }
                }
            }
        }
        return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
    }
}
