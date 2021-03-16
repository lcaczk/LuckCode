package com.wkk.bytedance2021.dp;

/**
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
