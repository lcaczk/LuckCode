package com.wkk.simulation;

/**
 * @author weikunkun
 * @since 2021/5/4
 */
public class MaxResult {
    public static int maxResult(int[] nums, int k) {
        // dp
        // 以i为结尾的最大得分
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int j = k;
            while (j > 0) {
                int idx = i - j;
                if (idx > 0) {
                    dp[i] = Math.max(dp[idx] + nums[i], dp[i]);
                }
                j--;
            }
        }
        return Math.max(dp[len - 1], 0);
    }

    public static void main(String[] args) {
        int[] array = {10, -5};
        int k = 3;
        maxResult(array, k);
    }
}
