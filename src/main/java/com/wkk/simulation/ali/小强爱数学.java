package com.wkk.simulation.ali;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 小强爱数学 {
    private static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int n = sc.nextInt();
            cal(A, B, n);
        }
    }

    private static void cal(int a, int b, int n) {
        long x = a;
        long y = a * a % mod - 2 * b % mod;
        if (n <= 2) {
            if (n == 1) {
                System.out.println(x);
            } else if (n == 2) {
                System.out.println(y);
            }
        }
        long[] dp = new long[n + 1];
        dp[0] = 2;
        dp[1] = a;
        dp[2] = y;
        long ans = 0;
        for (int i = 3; i <= n; i++) {
            dp[i] = (x * dp[i - 1] % mod - b * dp[i - 2] % mod + mod) % mod;
        }
        System.out.println(dp[n]);
    }
}
