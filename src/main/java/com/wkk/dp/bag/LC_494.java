package com.wkk.dp.bag;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/6/10
 */
public class LC_494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int half = (sum + target) / 2;
        if (target > sum || half * 2 != (sum + target)) {
            return 0;
        }
        // 前i个元素 放入容量为j的背包，有几种方法。
        int[][] dp = new int[n + 1][half + 1];
        // 初始化
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][half];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays(nums, target);
    }
}
