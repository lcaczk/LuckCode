package com.wkk.dp.sequences;

/**
 * @author weikunkun
 * @since 2021/7/19
 */
public class LC_55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        // dp[i] = dp[j] &&  j + diff = i;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            int num = nums[i];
            for (int k = 1; k <= num; k++) {
                if (i + k < n) {
                    dp[i + k] = true;
                }
                if (dp[n - 1]) {
                    return true;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        canJump(nums);
    }
}
