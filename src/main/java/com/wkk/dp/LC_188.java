package com.wkk.dp;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * @author weikunkun
 * @since 2021/5/3
 */
public class LC_188 {
    public static int maxProfit(int k, int[] prices) {
        // 类比买卖股票III
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2*k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = -prices[0];
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k ; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i-1][0], -prices[i]);
                } else if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 2 * k; i++) {
            res = Math.max(dp[len-1][i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] array = {2, 4, 1};
        maxProfit(k, array);
    }
}
