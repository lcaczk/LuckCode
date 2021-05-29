package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/29
 */
public class 藏宝图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String fist = sc.nextLine();
            String second = sc.next();
            if (containns(second, fist)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    private static boolean containns(String big, String small) {
        char[] first = big.toCharArray();
        char[] second = small.toCharArray();
        int[][] dp = new int[first.length + 1][second.length + 1];
        for (int i = 1; i < first.length; i++) {
            for (int j = 1; j < second.length; j++) {
                if (first[i-1] == second[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[first.length][second.length] == second.length;
    }
}
