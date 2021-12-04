package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/12
 */
public class AC_3662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 以array[i]为结尾的最大上升子序列和
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(cal(array));
    }

    private static long cal(int[] array) {
        int n = array.length;
        long[] dp = new long[n];
        dp[0] = array[0];
        long max = array[0];
        for (int i = 1; i < n; i++) {
            int cur = array[i];
            for(int j = 0; j < i; j++) {
                if (array[j] < cur) {
                    dp[i] = Math.max(dp[i], dp[j] + cur);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
