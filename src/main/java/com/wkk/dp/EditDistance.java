package com.wkk.dp;

/**
 * @Time: 2020/7/16上午11:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        // 初始化dp
        for(int i = 1; i<=m; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        for(int j = 1; j<=n; j++){
            dp[0][j] = dp[0][j-1] + 1;
        }
        int temp = 0;
        // 转移方程: dp[i][j] = Math.min(dp[i-1][j-1]+temp,
        //                       dp[i][j-1]+1, dp[i-1][j]+1);
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                // 因为我们的数组这只有效位从1开始
                // 所以标记当前遍历到的字符串的位置为i-1|j-1
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    temp = 0;
                }else {
                    temp = 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) + 1, dp[i-1][j-1] + temp);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "ivan2";
        String b = "ivan1";
        System.out.println(minDistance(a, b));
    }
}
