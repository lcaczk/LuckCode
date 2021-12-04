package com.wkk.dp.twosequences;

/**
 * @author weikunkun
 * @since 2021/5/29
 */
public class LC_10 {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            if (s == null && p == null) {
                return true;
            }
            return false;
        }
        int rows = s.length();
        int cols = p.length();
        s = "#" + s;
        p = "#" + p;
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        // dp[i][j] 以s[i] p[j]结尾，能否匹配
        // * 较为复杂
        // 1. 重复0次    s[i] 和 p[j-2]
        //       式例     aab
        //               c*a*b
        //    *将c这个字符干掉了 所以c*a*b能够匹配aab
        // 2. 重复若干次  s[i] 和 p[j-1] 匹配
        dp[0][0] = true;
        // 特殊条件处理
        // 当i==1时，dp[i-1][j]的第一个下表未定义。所以我们需要考虑dp[0][j]的情况。
        // 这对于p来说只可能是非常特殊的一类字符，即类似"a*b*c*"这类的，
        // 并且这里的星号都代表重复零次。其他任何p的表达式都不可能被parse成为一个空字符串。
        // 所以我们只要对这一类特殊情况做判断就行。
        for (int j = 2; j <= cols; j++) {
            if (p.charAt(j) == '*') dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (Character.isLowerCase(p.charAt(j))) {
                    dp[i][j] = (s.charAt(i) == p.charAt(j) && dp[i - 1][j - 1]);
                } else if (p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j) == '*') {
                    // 0次
                    boolean zero = dp[i][j - 2];
                    // 多次
                    boolean multi = dp[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    dp[i][j] = zero || multi;
                }
            }
        }
        return dp[rows][cols];

    }

    public static void main(String[] args) {
        Character.isLowerCase('a');
        isMatch("", ".*");
    }
}
