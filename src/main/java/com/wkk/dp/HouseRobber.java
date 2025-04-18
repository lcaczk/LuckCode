package com.wkk.dp;

/**
 * @Time: 2020/6/9下午9:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length-1];
    }
}
