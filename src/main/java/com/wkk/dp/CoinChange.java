package com.wkk.dp;

import java.util.Arrays;

/**
 * @Time: 2020/6/9下午2:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int amoutn = 10;
        int i = coinChange(coins, amoutn);
        System.out.println(i);
    }

}
