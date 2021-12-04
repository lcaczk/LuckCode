package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/10
 */
public class zfc {
    public static void main(String[] args) {
        // 空间换时间
        Scanner sc = new Scanner(System.in);
        String large = sc.nextLine();
        String small = sc.nextLine();
        System.out.println(isSubsequence(small, large));
        String a = "abc";
        String b = new String("abc");
        String c = "a" + "bc";
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }
    public static String isSubsequence(String small, String large) {
        char[] first = large.toCharArray();
        char[] second = small.toCharArray();
        int[][] dp = new int[first.length + 1][second.length + 1];
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i-1] == second[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[first.length][second.length] == second.length ? "yes" : "no";
    }
}
