package com.wkk.interview.bytedance2021.dp;

/**
 * 70 爬楼梯
 * @author weikunkun
 * @since 2021/4/13
 */
public class LC_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
