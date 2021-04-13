package com.wkk.dp;

/**
 * 打家劫舍II
 *
 * @author weikunkun
 * @since 2021/4/12
 */
public class LC_213 {
    public int rob(int[] nums) {
        // dp
        // 定义dp数组和下标含义
        // dp[i] 到第i间房子后，能获取的最大金额
        // dp[i] = Max(dp[i-1],dp[i-2] + nums[i]);
        // 按照分类
        // 1. 小偷偷的房间不包含头尾
        // 2. 小偷偷的房间包含头部
        // 3. 小偷偷的房间包含尾部
        // 1 包含在了2、3两种情况中了
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int first = rob(nums, 0, right - 1);
        int second = rob(nums, 1, right);
        return Math.max(first, second);
    }

    private int rob(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int len = right - left + 1;
        int[] dp = new int[len];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i+left]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        LC_213 lc_213 = new LC_213();
        int[] nums = {2,7,9,3,1};
        lc_213.rob(nums);
    }
}
