package com.wkk.dp.bag.total;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/30
 */
public class AC_1023 {
    // 完全背包问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {10, 20, 50, 100};
        int[] dp = new int[n + 1];
        int len = coins.length;
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[n]);
    }
}
