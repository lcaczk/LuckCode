package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 移动序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 1) {
                    cnt++;
                }
            }
            cal(arr, cnt);
        }
    }

    private static void cal(int[] arr, int cnt) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (arr[i] == 0) {
            i++;
        }

        while (arr[j] == 0) {
            j--;
        }
        int ans = j - i + 1 - cnt;
        System.out.println(ans);
    }
}
