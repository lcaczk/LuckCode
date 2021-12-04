package com.wkk.dp.bag.total;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/30
 */
public class LC_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        long[] dp = new long[nums + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) { // 物品容量
            for (int j = coins[i]; j <= nums; j++) { // 体积
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[nums]);
    }
}
