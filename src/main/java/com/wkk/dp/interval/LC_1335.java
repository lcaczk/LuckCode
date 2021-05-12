package com.wkk.dp.interval;

/**
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_1335 {
    /**
     * 有问题
     * @param jobDifficulty
     * @param d
     * @return
     */
    public static int minDifficulty(int[] jobDifficulty, int d) {
        // 思路 动归
        int len = jobDifficulty.length;
        // 前i个元素分为j天，返回最小的工作难度(分完组之后，所有组内的最大值找最小值)
        int[][] dp = new int[len + 1][d + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= d; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        int[] nums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            nums[i + 1] = jobDifficulty[i];
        }
        for (int i = 1; i <= len; i++) {
            for (int k = 1; k <= Math.min(d, i); k++) {
                for (int j = 0; j <= i-1; j++) {
                    int max = max(nums, j + 1, i);
                    dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + max);
                }
            }
        }
        return dp[len][d] == Integer.MAX_VALUE / 2 ? -1 : dp[len][d];
    }

    private static int max(int[] nums, int left, int right) {
        int max = 0;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nusm = {6, 5, 4, 3, 2, 1};
        minDifficulty(nusm, 2);
    }
}
