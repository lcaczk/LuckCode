package com.wkk.interview.bytedance2021.dp;

/**
 * 最长重复子数组
 *
 * @author weikunkun
 * @since 2021/4/13
 */
public class LC_718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j]表示A的前i项与B的前j项的最长重复子数组长度
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public int findLengthII(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1][len2];
        //
        // if nums1[i] == nums2[j]  dp[i][j] = dp[i-1][j-1] + 1;
        // else dp[i][j] = 0;
        int max = 0;
        for (int i = 0; i < len1; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }
        }

        for (int i = 0; i < len2; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
                max = Math.max(max, dp[0][i]);
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
