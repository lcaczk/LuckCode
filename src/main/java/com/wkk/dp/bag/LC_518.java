package com.wkk.dp.bag;

/**
 * @author weikunkun
 * @since 2021/6/10
 */
public class LC_518 {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                //不选第i个硬币
                dp[i][j] = dp[i - 1][j];
                //选择第i个硬币
                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];
                }
            }
        }
        return dp[n][amount];
    }

    public static int changeI(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                //不选第i个硬币
                dp[i][j] = dp[i - 1][j];
                //选择第i个硬币
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[n - 1][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(changeI(amount, coins));
    }
}
