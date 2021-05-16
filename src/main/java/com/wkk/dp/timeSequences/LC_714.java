package com.wkk.dp.timeSequences;

/**
 * @author weikunkun
 * @since 2021/5/16
 */
public class LC_714 {
    /**
     * 卖出时支付手续费
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        // 0 ： 持股
        // 1 ： 不持股（售出）
        // 第 i 天 持股/售出的最大收益
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return dp[len - 1][1];
    }

    /**
     * 买入时支付手续费
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitII(int[] prices, int fee) {
        int len = prices.length;
        // 0 ： 持股
        // 1 ： 不持股（售出）
        // 第 i 天 持股/售出的最大收益
        int[][] dp = new int[len][2];
        // 考虑买入的时候就支付手续费
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        // 最后一天，肯定是售出之后的结果 > 买入的结果
        return dp[len - 1][1];
    }

    public static void main(String[] args) {

    }
}
