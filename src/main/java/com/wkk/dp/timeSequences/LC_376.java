package com.wkk.dp.timeSequences;

/**
 * @author weikunkun
 * @since 2021/5/22
 */
public class LC_376 {
    public static int wiggleMaxLength(int[] nums) {
        // 时间序列模型
        int len = nums.length;
        // 以i为下标的最长摆动序列长度（以i结尾下降、以i为结尾上升）
        // 0 ： 上升
        // 1 ： 下降
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + 1);
            } else if (nums[i] < nums[i-1]){
                dp[i][1] = Math.max(dp[i-1][0] + 1, dp[i-1][1]);
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        wiggleMaxLength(nums);
    }
}
