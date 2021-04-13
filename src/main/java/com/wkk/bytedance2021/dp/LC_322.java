package com.wkk.bytedance2021.dp;

/**
 * 零钱兑换
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_322 {

    /**
     * 回溯
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0 || amount < 0) {
            return -1;
        }
        return process(coins, 0, amount);
    }

    private int process(int[] coins, int start, int amount) {
        if (start == coins.length) {
            return amount == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; k * coins[start] <= amount; k++) {
            int next = process(coins, start+1, amount - k * coins[start]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    /**
     * 动归
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeII(int[] coins, int amount) {
        // 动归
        // 动归
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int num : coins) {
                if ((i - num >= 0) && dp[i-num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i-num]+1, dp[i]);
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

    public static void main(String[] args) {
        int[] arr = {2};
        int[] arr1 = {1, 2, 5};
        int target = 3;
        target = 11;
        coinChangeII(arr, target);
    }
}
