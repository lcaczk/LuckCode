package com.wkk.dp.sequences;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class LC_322 {
    public static int coinChangeII(int[] coins, int amount) {
        // 动归
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int num : coins) {
                if ((i - num >= 0) && dp[i - num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - num] + 1, dp[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
