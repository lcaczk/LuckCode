package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class 密室闯关 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String string = sc.next();
            char[] str = string.toCharArray();
            long a = solve(str, n);
            System.out.println(a);
        }
    }

    private static long solve(char[] str, int n) {
        int statusCode = 0;
        // 状态编码
        for (int i = 0; i < n; i++) statusCode += str[i] - 'A';
        // dp[i][j]表示i个齿轮在状态编码为j的情况下有多少种齿轮组合
        long[][] dp = new long[n + 1][Math.max(statusCode, 25) + 1];
        // 一个齿轮在状态码确定时只能有一种状态，状态码可以是0-25
        for (int j = 0; j <= 25; j++) dp[1][j] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= statusCode; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j < 26)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 998244353;
                else
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 26] + 998244353) % 998244353;
            }
        }
        return dp[n][statusCode];
    }
}
