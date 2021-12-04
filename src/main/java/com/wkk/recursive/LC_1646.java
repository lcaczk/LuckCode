package com.wkk.recursive;

/**
 * @author weikunkun
 * @since 2021/8/23
 */
public class LC_1646 {
    private static int max = Integer.MIN_VALUE;
    public static int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i / 2] + ((i % 2 == 0) ? 0 : dp[i / 2 + 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(2));
    }
}
