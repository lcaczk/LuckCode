package com.wkk.dp.sequences;

/**
 * @author weikunkun
 * @since 2021/7/10
 */
public class LC_712 {
    public int minimumDeleteSum(String s1, String s2) {
        //求两个字符串的最小ASCII删除和等同于
        //求两个字符串的最大子序列的ASCII和
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                }else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int sum = 0;
        for(char c : s1.toCharArray())
            sum += c;
        for(char c : s2.toCharArray())
            sum += c;
        return sum - dp[m][n] * 2;
    }
}
