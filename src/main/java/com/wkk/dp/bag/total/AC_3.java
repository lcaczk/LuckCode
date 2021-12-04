package com.wkk.dp.bag.total;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/25
 */
public class AC_3 {
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
        oneDimension(v, w, size, n);
    }

    /**
     * 因为可以选择多次， 所以从前往后
     * 然后使用一维的方式处理
     * @param v
     * @param w
     * @param c
     * @param n
     */
    public static void oneDimension(int[] v, int[] w, int c, int n) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v[i]; j <= c; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[c]);
    }
}
