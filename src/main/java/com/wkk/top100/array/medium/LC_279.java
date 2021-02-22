package com.wkk.top100.array.medium;

/**
 * 279 完全平方数
 * @author weikunkun
 * @since 2021/2/21
 */
public class LC_279 {
    public int numSquares(int n) {
        // 动态规划
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            if (isSquares(i)) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < i ; j++) {
                min = Math.min(min, dp[i-j] + dp[j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private boolean isSquares(int n) {
        int half = n/2;
        for (int i = 1; i <= half; i++) {
            if (i * i == n) {
                return true;
            }
        }
        return false;
    }
}
