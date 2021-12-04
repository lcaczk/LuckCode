package com.wkk.interview.bytedance2021.dp;

/**
 * 丑数 II
 * @author weikunkun
 * @since 2021/4/13
 */
public class LC_264 {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        // 思路
        // 动态规划
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[a]*2, Math.min(dp[b] * 3, dp[c] * 5));
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        return dp[n-1];
    }
}
