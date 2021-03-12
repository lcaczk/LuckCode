package com.wkk.dp;

/**
 * @author weikunkun
 * @since 2021/3/12
 */
public class LC_91 {
    public int numDecodings(String s) {
        // 思路 ：动态规划
        if (null == s || s.length() == 0) {
            return 0;
        }
        // dp[i] = dp[i-2] + dp[i-1]   0< s.subString(i-2, i) < 26
        int len = s.length();
        if (len == 1 && s.equals("0")) {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String temp = s.substring(i-2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("26") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        LC_91 lc_91 = new LC_91();
        String s = "0";
        lc_91.numDecodings(s);
    }
}
