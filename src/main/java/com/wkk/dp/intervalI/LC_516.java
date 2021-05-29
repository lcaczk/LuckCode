package com.wkk.dp.intervalI;

/**
 * @author weikunkun
 * @since 2021/5/24
 */
public class LC_516 {
    public static int longestPalindromeSubseq(String s) {
        // 照抄问题 dp[i][j] => 字符串S[i:j]里是回文串的最长subsequence的长度。
        // 第一层是空间大小
        // 第二层循环起始点
        int n = s.length();
        s = "#" + s;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        char[] array = s.toCharArray();
        for (int len = 2; len <= n; len++) { // 先遍历区间
            for (int i = 1; i + len - 1 <= n; i++) { // 后遍历起始位置
                int j = i + len - 1; // 右边端点
                if (array[i] == array[j]) { // 若相等
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    int first = dp[i][j-1];
                    int second = dp[i+1][j];
                    dp[i][j] = Math.max(first, second);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        String s = "bbbd";
        longestPalindromeSubseq(s);
    }
}
