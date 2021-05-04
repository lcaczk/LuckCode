package com.wkk.dp;

/**
 * @author weikunkun
 * @since 2021/5/3
 */
public class LC_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        // 以 当前元素为结尾，是否形式翻转权利的最长连续的1
        int[][] dp = new int[len][2];
        // 0 未翻转1
        // 1 翻转1
        dp[0][1] = 1;
        dp[0][0] = nums[0] == 1 ? 1 : 0;
        int ans = Math.max(dp[0][1], dp[0][0]);
        for (int i = 1; i < len; i++) {
            if (nums[i] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 0;
            }
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
