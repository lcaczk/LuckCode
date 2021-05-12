package com.wkk.dp.interval;

import java.util.Arrays;

/**
 * 1278. 分割回文串 III
 *
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_1278 {
    public static int palindromePartition(String s, int _k) {
        int n = s.length();
        s = "#" + s;
        int K = _k;
        int[][] dp = new int[n+1][K+1];
        int[][] cost = new int[n+1][n+1];

        // fill
        for (int[] temp : dp) {
            Arrays.fill(temp, 1000);
        }
        for (int i = 1; i <= n; i++){
            dp[i][1]=calc(s.substring(1, i+1));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                cost[i][j] = cost[i][j] = calc(s.substring(i, j + 1));
            }
        }
        dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= Math.min(i, K); k++) {
                for (int l = 0; l <= i - 1; l++) {
                    dp[i][k] = Math.min(dp[i][k], dp[l][k-1] + cost[l + 1][i]);
                }
            }
        }
        return dp[n][K];

    }

    private static int calc(String t) {
        int a = 0;
        int left = 0;
        int right = t.length() - 1;
        while (left < right) {
            if (t.charAt(left) != t.charAt(right)) {
                a++;
            }
            left++;
            right--;
        }
        return a;
    }


    public static void main(String[] args) {
//        palindromePartition("aabbc", 3);
        int[][] dp = {{1,2,3}, {3,4,5}, {6,87,8}};
        System.out.println((double)4/2);
    }
}
