package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/8
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        cal(arr, n);
    }

    private static void cal(long[] arr, int n) {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            long cur = arr[i];
            long max = 0;
            int j = 0;
            while (j < i) {
                if (arr[j] < cur) {
                    max = Math.max(max, arr[j]);
                }
                j++;
            }
            ans[i] = max;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long tmp = ans[i] * (i + 1);
            res += tmp;
        }
        System.out.println(res);
    }
}
