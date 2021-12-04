package com.wkk.dp.bag.zero;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/30
 */
public class AC_278 {
    // 01背包 求方案数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[M + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = M; j >= arr[i]; j--) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[M]);
    }
}
