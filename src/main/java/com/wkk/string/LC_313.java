package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/8/9
 */
public class LC_313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] ans = new int[len]; // 存储每个元素被乘了多少次
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < len; k++) {
                if (dp[ans[k]] * primes[k] < min) {
                    min = dp[ans[k]] * primes[k];
                }
            }
            dp[i] = min;
            // 重新比较，若是相等 则进行 + 1操作
            for (int k = 0; k < len; k++) {
                if (min == dp[ans[k]] * primes[k]) {
                    ans[k]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        System.out.println(nthSuperUglyNumber(n, primes));
    }
}
