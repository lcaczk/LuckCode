package com.wkk.bytedance2020;

/**
 * @Time: 2020/7/25上午10:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if((text1 == null || m == 0) || (text2 == null || n == 0)){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        int max = 0;
        // 第一行 第一列 均为0
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
