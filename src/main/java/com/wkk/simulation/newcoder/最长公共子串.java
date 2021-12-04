package com.wkk.simulation.newcoder;

/**
 * @author weikunkun
 * @since 2021/6/11
 */
public class 最长公共子串 {
    public static String LCS(String str1, String str2) {
        str1 = "#" + str1;
        str2 = "#" + str2;
        int m = str1.length();
        int n = str2.length();
        int idx = 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (str2.charAt(1) == str1.charAt(i)) {
                dp[i][1] = 1;

            }
        }

        for (int i = 1; i < n; i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                dp[1][i] = 1;
            }
        }
        int max = 1;
        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        idx = i;
                    }
                }
            }
        }
        return str1.substring(idx - max + 1, idx + 1);
    }

    public static void main(String[] args) {
        String a = "22222";
        String b = "22222";
        System.out.println(LCS(a, b));
    }
}
