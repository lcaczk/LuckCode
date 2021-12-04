package com.wkk.acwing.everyday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/12
 */
public class AC_3801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, n);
        }
    }

    private static void cal(int[] arr, int n) {
        int max = Arrays.stream(arr).max().getAsInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            while (i < n && max == arr[i]) {
                i++;
                t++;
            }
            ans = Math.max(ans, t);
        }
        System.out.println(ans);
    }

    // 前缀和 超时
    private static int[] preSum(int[] arr, int n) {
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = arr[i - 1] + preSum[i - 1];
        }
        return preSum;
    }
}
