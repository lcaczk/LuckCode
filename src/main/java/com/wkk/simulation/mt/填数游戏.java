package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class 填数游戏 {
    static int mod = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int j = i > k ? k : i;
            for (; j > 0; j--) {
                dp[i][0] = (dp[i][0] + dp[i - j][0]) % mod;
                if (j < d) {
                    dp[i][1] = (dp[i][1] + dp[i - j][1]) % mod;
                } else {
                    dp[i][1] = (dp[i][1] + dp[i - j][0]) % mod;
                }
            }
        }

        System.out.println(dp[n][1]);
    }
}
