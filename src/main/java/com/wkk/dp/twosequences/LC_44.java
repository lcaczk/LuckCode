package com.wkk.dp.twosequences;

/**
 * 44. 通配符匹配
 * @author weikunkun
 * @since 2021/5/29
 */
public class LC_44 {
    public boolean isMatch(String s, String p) {
        s = "#" + s;
        p = "#" + p;
        int rows = s.length();
        int cols = p.length();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[rows][cols];

        dp[0][0] = true;
        for (int j = 1; j < cols; j++) {
            if (pp[j] == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (Character.isLowerCase(pp[j])) {
                    dp[i][j] = (ss[i] == pp[j]) && dp[i-1][j-1];
                } else if (pp[j] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pp[j] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
