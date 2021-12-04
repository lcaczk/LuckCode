package com.wkk.interview.bytedance2021.dp;

/**
 * 1143. 最长公共子序列
 * 思路 和编辑距离类似
 * @author weikunkun
 * @since 2021/4/2
 */
public class LC_1143 {
    /**
     * 首先定义好第一行和第一列
     * 假设 行 text2
     * 假设 列 text1
     * 对于行： text1[0] 和text2[i]中任意一位置字符相同，则i-len位置为1
     * 对于列： 同理
     * 非首行和首列： 1. dp[i-1][j]  dp[i][j-1] dp[i-1][j-1]+1 最大
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int max = 0;
        // 初始化行
        // 初始化列
        // 遍历整个
        int rows = dp.length;
        int cols = dp[0].length;
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < rows; i++) {
            dp[i][0] = Math.max(dp[i-1][0], text1.charAt(i) == text2.charAt(0) ? 1 : 0);
            max = Math.max(dp[i][0], max);
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i] = Math.max(dp[0][i-1], text1.charAt(0) == text2.charAt(i) ? 1 : 0);
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (text2.charAt(j) == text1.charAt(i)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
