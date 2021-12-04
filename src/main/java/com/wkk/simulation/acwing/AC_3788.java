package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class AC_3788 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            int cur = preSum[i];
            int rst = preSum[n] - cur;
            if (cur == rst) {
                count++;
            }
        }
        System.out.println(count);
    }
}
