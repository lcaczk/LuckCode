package com.wkk.dp.intervalI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/27
 */
public class AC_282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        cal(arr, n);
    }

    private static void cal(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];
        // 前缀和，preSum[i] = sum[0..i)
        int[] preSum = getPrefixSum(arr);
        for (int[] tmp : dp) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        for (int len = 1; len < n; len++) { // 起始位置
            for (int i = 1; i + len <= n; i++) { // 段长
                int j = i + len; // 右端点
                dp[i][j] = Integer.MAX_VALUE / 2;
                for (int k = i; k < j - 1; k++) {  // 分割点
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + preSum[j] - preSum[i - 1]);
                }

            }
        }
        System.out.println(dp[1][n]);
    }

    private static int[] getPrefixSum(int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        return prefixSum;
    }
}
