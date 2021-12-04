package com.wkk.dp.bag.zero;

import java.util.Scanner;

/**
 * 01 背包问题
 *
 * @author weikunkun
 * @since 2021/7/25
 */
public class AC_2 {
    /**
     * 01背包
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[] dp = new int[size + 1];
        for (int i = 0; i < n; i++) {
            for (int j = size; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[size]);
    }
}
