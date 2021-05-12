package com.wkk.dp.interval;

import java.util.Arrays;

/**
 * 和813一个套路
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_410 {
    public int splitArray(int[] nums, int m) {
        // 二分法
        // 动归
        int len = nums.length;
        // 前i个元素，分割成j组，使得j个子数组各自和的最大值最小
        int[][] dp = new int[len+1][m+1];
        // 前缀和，preSum[i] = sum[0..i)
        int[] preSum = getPrefixSum(nums);
        for (int[] tmp : dp) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= len; i++) { // 元素
            for (int j = 1; j <= Math.min(i, m); j++) { // 组
                if (j == 1) {
                    dp[i][j] = preSum[i];
                }
                for (int l = 0; l < i; l++) {// 前 i-1 的元素
                    // dp[l][j-1]已经只知道结果
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j-1], preSum[i] - preSum[l]));
                }
            }
        }
        return dp[len][m];
    }

    private int[] getPrefixSum(int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        return prefixSum;
    }
}
