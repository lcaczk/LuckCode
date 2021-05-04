package com.wkk.dp;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * @author weikunkun
 * @since 2021/5/3
 */
public class LC_123 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        long[][] dp = new long[n][4];
        // 0 持有1股
        // 1 售出1股
        // 2 持有2股
        // 3 售出2股
        // 第0天 持有一股， 第0天不可能出现售出的现象，只有持有第一股的可能
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
        }
        long res = 0;
        for (int i = 0; i < 4; i++) {
            res = Math.max(res, dp[n - 1][i]);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int[] price = {1, 2, 3, 4, 5};
        maxProfit(price);
    }
}
