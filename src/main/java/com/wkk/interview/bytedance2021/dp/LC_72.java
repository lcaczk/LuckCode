package com.wkk.interview.bytedance2021.dp;

/**
 * @author weikunkun
 * @since 2021/3/23
 */
public class LC_72 {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        // 编辑距离
        int[][] dp = new int[sLen + 1][tLen + 1];
        // 边界处理
        dp[0][0] = 0;
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= tLen; i++) {
            dp[0][i] = i;
        }

        // 正常情况
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        return dp[sLen][tLen] == 1;
    }

    public static void main(String[] args) {
        LC_72 lc_xxx = new LC_72();
        lc_xxx.isOneEditDistance("cab", "ad");
    }
}
