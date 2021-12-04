package com.wkk.interview.bytedance2021.dp;

import java.util.Arrays;

/**
 * 300 最长上升子序列
 *
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // 如果最长递增子序列以nums[i]为最后的字符
        // 则num[0-i-1]的每一个位都有可能作为倒数第二大的子序列的尾部
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        String a = "1";
        String b = "2";
        System.out.println(a.compareTo(b));
    }
}

