package com.wkk.dp.sequences;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/27
 */
public class AC_896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        cal(arr, n);
    }

    private static void cal(int[] arr, int n) {
        int[] q = new int[n + 1];
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = len;
            while (l < r) {
                int mid = l + r + 1>> 1;
                if (q[mid] < arr[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            len = Math.max(len, r + 1);
            q[r + 1] = arr[i];
        }
        System.out.println(len);
    }
}
