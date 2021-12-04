package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/30
 */
public class AC_3824 {
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
        int count = 0;
        // 去除开头结尾的休息
        int l = 0;
        int r = n - 1;
        while (l< n && r >= 0 && (arr[l] == 0 || arr[r] == 0)) {
            if (arr[l] == 0) {
                l++;
            } else if (arr[r] == 0) {
                r--;
            }
        }
        if(l < r) {
            System.out.println(0);
        }
        int countZero = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] == 1) {
                count++;
                countZero = 0;
            } else {
                countZero++;
                if (countZero == 2) {
                    count--;
                    countZero = 0;
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
