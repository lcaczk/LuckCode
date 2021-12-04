package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/26
 */
public class 乘车问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, n, m);
        }
    }

    private static void cal(int[] arr, int n, int m) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res + arr[i] > m) {
                res = 0;
                count++;
            }
            res += arr[i];
        }
        if (res > 0) {
            count++;
        }
        System.out.println(count);
    }
}
