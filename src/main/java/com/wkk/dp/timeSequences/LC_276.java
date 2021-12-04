package com.wkk.dp.timeSequences;

/**
 * 时间序列模型 --- 栅栏涂色
 *
 * @author weikunkun
 * @since 2021/6/25
 */
public class LC_276 {
    public int numWays(int n, int k) {
        if (k == 1) return n > 2 ? 0 : 1;
        if (n <= 2) return (int) Math.pow(k, n);
        int[][] dp = new int[n][2];
        // 0 上一个颜色相同
        // 1 上一个颜色不同
        dp[0][1] = k;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}
